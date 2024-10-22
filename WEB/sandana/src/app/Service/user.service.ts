import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { user } from '../Models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users:user[]=[]
  user:user = new user("","","");
 
  
  constructor(public http:HttpClient) { 
    let url="http://localhost:8081/user/findAll"
    this.http.get<user[]>(url)
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

  async getUser() {
    let email = localStorage.getItem("email");
    if (email && email !== "") {
        let url = "http://localhost:8081/user/findById?UserId="+email;
        console.log(email);
        try {
            const response = await this.http.get<user>(url).toPromise();
            if (response) {
                this.user = response;
                return this.user;
            } else {
                console.error("User not found.");
                return null;
            }
        } catch (error) {
            console.error("Error fetching user", error);
            return null;
        }
    }
    return null;
}


  logOut() {
    localStorage.removeItem("email");
  }

  saveUser(user:user) {
    this.user=user
    localStorage.setItem("email", user.email);
  }
}
