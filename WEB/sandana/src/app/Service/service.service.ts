import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  url="http://localhost:8081/user/findAll"
  constructor(public http:HttpClient) { 
    this.http.get<any>(this.url)
           .subscribe (response => {
             console.log(response);
           })
  }
}
