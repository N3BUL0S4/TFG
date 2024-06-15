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

  findById(id:Number){
    let result=false;
    this.http.get<article[]>(this.url)
           .subscribe (response => {
            if (response != null) {
              response.forEach(a => {
                if(a.id==id){
                  result = true
                }
              });
            }
           })
           return result;
  }

  create(article:article){
    let url = "http://localhost:8081/Article/create"
    this.http.post(url,article)
      .subscribe(response => {
        console.log(response);
      })
  }
}
