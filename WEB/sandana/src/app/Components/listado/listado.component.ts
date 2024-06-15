import { Component } from '@angular/core';
import { ArticleService } from '../../Service/article.service';
import { article } from '../../Models/article';
import { media } from '../../Models/media';
import { MediaService } from '../../Service/media.service';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css'
})
export class ListadoComponent {
  articles: article[]=[];
  articleFiltered:article[] = []
  medias:media[]=[];
  mediasId:media[]=[];

  constructor(public ms:MediaService, public as:ArticleService) {
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
    let articles:article[]= []
    this.articles.forEach(a => {
      console.log(a.model)
      if (a.description.toLowerCase() === modelo.value.toLowerCase()) {
        articles.push(a)
      }
    });
    console.log(articles)
    this.articleFiltered=articles
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
