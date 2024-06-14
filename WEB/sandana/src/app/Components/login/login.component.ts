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
      alert("Inicio de sesion incorrecto")
      // Lógica para enviar los datos del formulario al servidor
    }
  }

  register() {
    this.ruta.navigate(['register']);
  }
}
