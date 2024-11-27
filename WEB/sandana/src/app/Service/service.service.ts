import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Article } from '../Models/Article';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  // article:article[]=[]
  // url="http://localhost:8081/A rticle/findAll"
  
  // constructor(public http:HttpClient) { 
  //   this.http.get<article[]>(this.url)
  //          .subscribe (response => {
  //           if (response != null) {
  //             response.forEach(a => {
  //               this.users.push(a);
  //             });
  //           }
  //          })
  // }
}
