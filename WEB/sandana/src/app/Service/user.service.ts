import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { user } from '../Models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users:user[]=[]
  user:user = new user("","","");
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

  create(user:user) {
    let url = "http://localhost:8081/user/create"
    this.http.post(url,user)
      .subscribe(response => {
        console.log(response);
      })
  }

  saveUser(user:user) {
    this.user=user
  }
}
