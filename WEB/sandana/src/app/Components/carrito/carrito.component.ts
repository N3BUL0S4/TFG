import { Component } from '@angular/core';
import { cart } from '../../Models/carts';
import { CartService } from '../../Service/cart.service';
import { article } from '../../Models/article';
import { user } from '../../Models/user';
import { UserService } from '../../Service/user.service'

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrl: './carrito.component.css'
})

export class CarritoComponent {

  user:user = new user("","","");
  carts:cart[]=[];
  articles:article[]=[]

  constructor(private cs:CartService, private us:UserService){ 
    this.carts=cs.getCart();
    console.log(this.carts);
  }

  // Array que simula productos en el carrito


  // Calcula el precio total del carrito
  getTotalPrice() {
    return 0;
  }

  // Actualiza el carrito al cambiar la cantidad
   updateCart() {
//     const item = this.carts[index];
//     if (item.amount < 1) {
//       item.amount = 1; // Evitar cantidades menores a 1
//     }
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
