import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { cart } from '../Models/carts';
import { UserService } from './user.service';
import { article } from '../Models/article';
import { ArticleService } from './article.service';

@Injectable({
  providedIn: 'root'
})
export class CartService { 
    carts:cart[]=[];
    articles:article[]=[];

    constructor(public http:HttpClient, public us:UserService, public as:ArticleService) {
      let url = "http://localhost:8081/Cart/findAll"
      this.http.get<cart[]>(url)
             .subscribe (response => {
              if (response != null) {
               this.carts=response
                console.log(this.carts)
              }
             })
    }

    getCart() {
      let cart:cart[]=[]
      let cartId:Number = 0
      let url="http://localhost:8081/LineCart/findAll"
      this.carts.forEach(c => {
          console.log(c.userId)
          cartId = c.cartId
      }); 
      this.http.get<cart[]>(url)
             .subscribe (response => {
              console.log(response)
              if (response != null) {
                response.forEach(a => {
                  if (a.cartId == cartId) {
                    cart.push(a)    
                  }
                });
              }
            })
      return cart; 
    }


    getArticle(ArticleId:Number) {
      return this.as.GetById(ArticleId)
    }
}