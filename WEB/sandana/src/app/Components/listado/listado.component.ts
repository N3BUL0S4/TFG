import { Component } from '@angular/core';
import { ArticleService } from '../../Service/article.service';
import { Article } from '../../Models/Article';
import { Media } from '../../Models/media';
import { MediaService } from '../../Service/media.service';
import { CartService } from '../../Service/cart.service';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css'
})
export class ListadoComponent {
  articles: Article[]=[];
  articleFiltered:Article[] = []
  medias:Media[]=[];
  mediasId:Media[]=[];

  constructor(public ms:MediaService, public as:ArticleService, public cs:CartService) {
    this.articles = as.articles
    this.articleFiltered = as.articles
    this.medias = this.ms.medias
    
  }

  firstImage(articleId:Number) {
    let image
    let contador = 0
    this.mediasId = []
    this.medias.forEach(m => {
      if (m.articleId==articleId) {
        if (contador == 0) {
          image=m.source
          contador++
        } else { 
        this.mediasId.push(m)
        }
      }
    });
    return image
  }

  Aplicarfiltro(hombre:any,mujer:any,modelo:any) {
    this.articleFiltered=[]
    let articles:Article[]= []
    console.log(modelo.value)
    this.articles.forEach(a => {
      if (a.description.toLowerCase() == modelo.value.toLowerCase()) {
        articles.push(a)
      }
    });
    console.log(articles)
    this.articleFiltered=articles
    window.location.reload();
  }

  addCart(id:Number){
    this.cs.addLineCart(id)
  }

  getModels(){
    let articles:String[]=[]
    this.articles.forEach(a => {
      if (!articles.includes(a.model)){
        articles.push(a.model)
      }
    });
    return articles
  }
}
