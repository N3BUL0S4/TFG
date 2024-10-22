import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../Service/user.service';
import { user } from '../../Models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  user:user|null

  constructor(public ruta: Router, public us: UserService) {
    this.user = new user("","","")
    this.initializeUser();
  }

  async initializeUser() {
      try {
          this.user = await this.us.getUser();
          if (this.user) {
              console.log("User retrieved successfully:", this.user);
          } else {
              console.log("User not found.");
          }
      } catch (error) {
          console.error("Error occurred while getting user:", error);
      }
  }

  login() {
      this.ruta.navigate(['login']);
  }

  logOut() {
      this.us.logOut();
      window.location.reload();
  }
}

