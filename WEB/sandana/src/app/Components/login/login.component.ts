import { Component, OnInit } from '@angular/core';
import { UserService } from '../../Service/user.service';
import { user } from '../../Models/user';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent{
  users:user[]=[]
  user:user = new user("","","")
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
      let user:user = this.user
      user.email = this.loginForm.value.email;
      user.passwd = this.loginForm.value.password;      
      this.users.forEach(u => {
        if(u.email==user.email) {
          if(u.passwd==user.passwd) {
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
