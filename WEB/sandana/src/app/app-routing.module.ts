import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './Components/index/index.component';
import { LoginComponent } from './Components/login/login.component';
import { ListadoComponent } from './Components/listado/listado.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { RegisterComponent } from './Components/register/register.component';
import { CreateArticleComponent } from './Components/create-article/create-article.component';

const routes: Routes = [
  {path:'',component:IndexComponent},
  {path:'login',component:LoginComponent},
  {path:'listado',component:ListadoComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'register',component:RegisterComponent},
  {path:'crear',component:CreateArticleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
