import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../Models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users:User[]=[]
  user:User = new User("","","");
 
  
  constructor(public http:HttpClient) { 
    let url="http://localhost:8081/user/findAll"
    this.http.get<User[]>(url)
           .subscribe (response => {
            if (response != null) {
              response.forEach(a => {
                this.users.push(a);
              });
            }
           })
  }

  create(user:User) {
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
        try {
            const response = await this.http.get<User>(url).toPromise();
            if (response) {
                this.user = response;
                return this.user;
            } else {
                console.error("User not found.");
                return new User("", "", "");
            }
        } catch (error) {
            console.error("Error fetching user", error);
            return new User("", "", "");
        }
    }
    return new User("", "", "");
}


  logOut() {
    localStorage.removeItem("email");
  }

  saveUser(user:User) {
    this.user=user
    localStorage.setItem("email", user.email);
  }
}
