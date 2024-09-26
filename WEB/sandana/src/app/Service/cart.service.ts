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
    cartId:Number=0;

    constructor(public http:HttpClient, public us:UserService, public as:ArticleService) {
        this.cartId = us.user.cartId
        let url="http://localhost:8081/Cart/findByArticleId?articleId={{articleId}}"
        this.http.get<cart[]>(url)
               .subscribe (response => {
                if (response != null) {
                    response.forEach(a => {
                      this.carts.push(a)
                    });
                  }
               })
        this.carts.forEach(c => {
          this.articles=as.GetById(c.idArticle)
        }); 
    }
    

    create(cart: cart) {
        let url="http://localhost:8081/Media/create"
        this.http.post(url,cart)
          .subscribe(response => {
            console.log(response);
          })
      }
}