import { Component, OnInit } from '@angular/core';
import { UserService } from '../../Service/user.service';
import { User } from '../../Models/User';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent{
  users:User[]=[]
  user:User = new User("","","")
  loginForm!: FormGroup;

  constructor(private fb: FormBuilder, public us: UserService, public ruta:Router) {
    this.users = us.users;
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      console.log('Formulario válido:', this.loginForm.value);
      let user:User = this.user
      user.email = this.loginForm.value.email;
      user.passwd = this.loginForm.value.password;      
      this.users.forEach(u => {
        if(u.email==user.email) {
          if(u.passwd==user.passwd) {
            console.log(u);
            this.us.saveUser(u);

            this.ruta.navigate(['listado']);
          }
        }
        
      });
    }
  }

  register() {
    this.ruta.navigate(['register']);
  }
}
