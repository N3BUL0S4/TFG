import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { user } from '../Models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users:user[]=[]
  url="http://localhost:8081/user/findAll"
  
  constructor(public http:HttpClient) { 
    this.http.get<user[]>(this.url)
           .subscribe (response => {
            if (response != null) {
              response.forEach(a => {
                this.users.push(a);
              });
            }
           })
  }

}
