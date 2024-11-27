import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Media } from '../Models/media';

@Injectable({
  providedIn: 'root'
})
export class MediaService {
  medias:Media[]=[]
  constructor(public http:HttpClient) { 
    let url="http://localhost:8081/Media/findAll"
    this.http.get<Media[]>(url)
           .subscribe (response => {
            if (response != null) {
              response.forEach(a => {
                this.medias.push(a)
              });
            }
           })
    }

  findAllbyArticleId(articleId: Number) {
    let url="http://localhost:8081/Media/findByArticleId?articleId={{articleId}}"
    let m:Media[]=[]
    this.http.get<Media[]>(url)
           .subscribe (response => {
            if (response != null) {
              response.forEach(a => {
                m.push(a)
              });
            }
           })
    return m
    }

    create(media: Media) {
      let url="http://localhost:8081/Media/create"
      this.http.post(url,media)
        .subscribe(response => {
          console.log(response);
        })
    }
} 
