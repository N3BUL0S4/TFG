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
  carts:LineCart[] = [];
  articles:Article[]=[]
  article:Article = new Article(0,"","","","","","",0)

  constructor(private cs: CartService, private us: UserService) {
    this.loadLineCarts();
  }
  
  async loadLineCarts() {
    this.carts = await this.cs.getLineCart(); // Asegúrate de que getLineCart devuelve una promesa
    console.log(this.carts);
  }

  getArticle(lineCart: LineCart)  {
    console.log(lineCart);
    if (this.article!= null){
      if (this.article.id == 0 || this.article.id != lineCart.articleId) {
        this.loadArticle(lineCart).then((a) => {
          this.article = a
        })  
      }
      console.log(this.article)
    }
    console.log(this.article)
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
      this.cs.updateCart(lineCart)
      console.log(lineCart)
   }

  // Elimina un producto del carrito
   removeItem() {
//     this.carts.splice(index, 1);
   }

  // Simula el proceso de checkout
checkout() {
//     alert('Gracias por tu compra. Total a pagar: ' + this.getTotalPrice());
//     this.carts = []; // Vaciar el carrito después del pago
   }
}
