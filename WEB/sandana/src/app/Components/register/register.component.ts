import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../../Models/User';
import { UserService } from '../../Service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  registerForm!: FormGroup;
  users:User[]=[];
  user:User = new User("","","");

  constructor(private fb: FormBuilder, public us:UserService, public ruta:Router) {
    this.users = us.users;
  }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required,]],
      role: ['', [Validators.required]]
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      let user:User = this.user
      user.email = this.registerForm.value.email;
      user.passwd = this.registerForm.value.password;
      user.rol = this.registerForm.value.role
      
      this.users.forEach(u => {
        if(u.email==user.email) {
          
          user.email=""
          user.passwd=""
          user.rol=""
        }
        
      });
      if (user.email!="") {
        alert("Usuario credo correctamente")
        this.us.create(user)
        this.us.saveUser(user)
        this.ruta.navigate(['listado']);
      } else {
        alert("El email ya existe")
      }
    }
  }

  login() {

  }
}
