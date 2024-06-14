import { Injectable } from '@angular/core';
import { article } from '../Models/article';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  articles:article[]=[]
  url="http://localhost:8081/Article/findAll"
  
  constructor(public http:HttpClient) { 
    this.http.get<article[]>(this.url)
           .subscribe (response => {
            if (response != null) {
              response.forEach(a => {
                this.articles.push(a);
              });
            }
           })
  }
}
