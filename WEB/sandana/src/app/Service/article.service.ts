import { Injectable } from '@angular/core';
import { Article } from '../Models/Article';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  articles:Article[]=[]
  article:Article=new Article(0,"","","","","","",0)
  url="http://localhost:8081/Article/findAll"
  
  constructor(public http:HttpClient) { 
    this.http.get<Article[]>(this.url)
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
    this.http.get<Article[]>(this.url)
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

  async GetById(id: Number) {
    const url = `http://localhost:8081/Article/findById?articleId=${id}`;

    try {
        let respuesta = await this.http.get<Article>(url).toPromise();
        if (respuesta) {
          this.article = respuesta;
          console.log(this.article)
        } 
        return this.article
    } catch (error) {
        console.error('Error al obtener el artículo:', error);
        throw error; // Opcional: vuelve a lanzar el error para manejarlo más arriba
    }
  }

  create(article:Article){
    let url = "http://localhost:8081/Article/create"
    this.http.post(url,article)
      .subscribe(response => {
        console.log(response);
      })
  }
}
