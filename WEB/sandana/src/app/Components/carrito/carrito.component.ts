import { Component } from '@angular/core';
import { cart } from '../../Models/carts';
import { CartService } from '../../Service/cart.service';
import { article } from '../../Models/article';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrl: './carrito.component.css'
})
export class CarritoComponent {

  articles:article[] =[]
  constructor(private cs: CartService){ 
    this.articles = cs.articles;
  }

  // Array que simula productos en el carrito


  // Calcula el precio total del carrito
  getTotalPrice() {
    
  }

  // Actualiza el carrito al cambiar la cantidad
//   updateCart(index: number): void {
//     const item = this.carts[index];
//     if (item.amount < 1) {
//       item.amount = 1; // Evitar cantidades menores a 1
//     }
//   }

//   // Elimina un producto del carrito
//   removeItem(index: number): void {
//     this.carts.splice(index, 1);
//   }

//   // Simula el proceso de checkout
//   checkout(): void {
//     alert('Gracias por tu compra. Total a pagar: ' + this.getTotalPrice());
//     this.carts = []; // Vaciar el carrito después del pago
//   }
}
