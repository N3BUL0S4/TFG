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

  constructor(public ruta:Router, public us:UserService){
    console.log(us.user.rol.length)
  }
  
  login() {
    this.ruta.navigate(['login']);
  }

  logOut(){
    this.us.user= new user("","","");
    window.location.reload();
  }
}
