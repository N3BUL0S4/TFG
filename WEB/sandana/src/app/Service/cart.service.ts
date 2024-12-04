import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from '../Models/Cart';
import { UserService } from './user.service';
import { Article } from '../Models/Article';
import { ArticleService } from './article.service';
import { User } from '../Models/User';
import { LineCart } from '../Models/LineCart';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
    lineCarts:LineCart[]=[]
    carts:Cart[]=[];
    articles:Article[]=[];
    user:User = new User("","","");
    cart:Cart= new Cart(0,"")

    constructor(public http:HttpClient, public us:UserService, public as:ArticleService) {
      this.initializeUser();
      let url = "http://localhost:8081/Cart/findAll"
      this.http.get<Cart[]>(url)
             .subscribe (response => {
              if (response != null) {
                response.forEach(c => {
                  this.carts.push(c)
                });
                console.log(this.carts)
              }
             })
    }

    async getLineCart(): Promise<LineCart[]> {
      this.user = await this.us.getUser();
    
      if (this.user.email !== "") {
        // Espera a obtener el carrito usando una Promesa
        const cart = await new Promise<Cart>((resolve, reject) => {
          this.getCart(this.user).subscribe(
            cart => resolve(cart),
            error => reject(error)
          );
        });
    
        this.cart.idUser = cart.idUser;
        this.cart.idCart = cart.idCart;
        console.log(this.cart);
      }
    
      console.log(this.cart);
      
      if (this.cart.idCart) {
        const url = `http://localhost:8081/LineCart/findByCartId?cartId=${this.cart.idCart}`;
    
        try {
          const response = await this.http.get<any>(url).toPromise();
          this.lineCarts = response;
          console.log(response);
          return this.lineCarts; // Devuelve la respuesta
        } catch (error) {
          console.error('Error fetching line cart:', error);
          return []; // Maneja el error
        }
      }
    
      return []; // Si no hay usuario o carrito
    }
    
  
    getCart(user: User): Observable<Cart>{
      let url = "http://localhost:8081/Cart/findAll";
      return this.http.get<Cart[]>(url).pipe(
        map(response => {
          const cart: Cart = { idUser: "", idCart: 0 }; // Inicializa el cart
          if (response) {
            response.forEach(a => {

              if (a.idUser == user.email) {
                cart.idUser = a.idUser;
                cart.idCart = a.idCart;

              }
            });
          }
          return cart; // Devuelve el cart encontrado
        })
      );
    }
  
    updateCart(lineCart:LineCart) {
      let url1="http://localhost:8081/LineCart/deleteById?lineCartId={{lineCart.id}}";
      this.http.get<any>(url1)
             .subscribe (response => {
               console.log(response.products);
             })
      let url2="http://localhost:8081/LineCart/create"
      this.http.put(url2,lineCart)
        .subscribe(response => {
          console.log(response);
        })
    }
  
    removeCart(id:Number){
      let url="http://localhost:8081/LineCart/deleteById?lineCartId="+id
      this.http.get<any>(url)
             .subscribe (response => {
               console.log(response);
             })
    }

    async addLineCart(id:Number) {
      let lineCart = new LineCart(0,id,1,0)
      let user=new User("","","")
      lineCart.articleId = id;
      await this.us.getUser().then((result) => {
        console.log(result)
        user=result
      });

      const cart = await new Promise<Cart>((resolve, reject) => {
        this.getCart(user).subscribe(
          cart => resolve(cart),
          error => reject(error)
        );
      });
      
      lineCart.cartId = cart.idCart;

      console.log(lineCart)
      let url="http://localhost:8081/LineCart/create"
      this.http.post(url,lineCart)
        .subscribe(response => {
          console.log(response);
        })
    }

    async initializeUser() {
      try {
          this.user = await this.us.getUser();
          if (this.user) {
              console.log("User retrieved successfully:", this.user);
          } else {
              console.log("User not found.");
          }
      } catch (error) {
          console.error("Error occurred while getting user:", error);
      }
    }

  getArticle(articleId: Number)  {
    return this.as.GetById(articleId)
  }
}
