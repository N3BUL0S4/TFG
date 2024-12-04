import { Component } from '@angular/core';
import { Cart } from '../../Models/Cart';
import { CartService } from '../../Service/cart.service';
import { Article } from '../../Models/Article';
import { User } from '../../Models/User';
import { UserService } from '../../Service/user.service'
import { LineCart } from '../../Models/LineCart';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrl: './carrito.component.css'
})

export class CarritoComponent {

  user:User = new User("","","");
  carts:LineCart[] = []
  articles:Article[]=[]
  article:Article = new Article(0,"","","","","","",0)

  constructor(private cs: CartService, private us: UserService) {
    this.loadLineCarts();
    
  }
  
  async loadLineCarts() {
    this.carts = await this.cs.getLineCart(); // Asegúrate de que getLineCart devuelve una promesa
    this.loadArticles();  
  }
  loadArticles() {
    this.carts.forEach(c => {
      this.loadArticle(c).then((result) => {
        this.articles.push(result) 
      });
    });
    
  }
  getArticle(lineCart: LineCart): Article {
    
    this.articles.forEach(element => {
      if(element.id == lineCart.articleId)
        this.article=element
    });
    return this.article
  }

  async loadArticle(lineCart: LineCart) {
    let article = await this.cs.getArticle(lineCart.articleId)
    return article
  }

  getTotalPrice() {
    return 0;
  }

  getSubtotal(pvp:number, cant:number) {
    return (pvp*cant)
  }
   updateCart(lineCart: LineCart) {
    console.log(lineCart)
   }

  // Elimina un producto del carrito
   removeItem(id: Number) {
    this.cs.removeCart(id)
    window.location.reload();
   }

  // Simula el proceso de checkout
checkout() {
//     alert('Gracias por tu compra. Total a pagar: ' + this.getTotalPrice());
//     this.carts = []; // Vaciar el carrito después del pago
   }
}
