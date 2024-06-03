import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './Components/index/index.component';
import { NabvarComponent } from './Components/nabvar/nabvar.component';

const routes: Routes = [
  {path:'Index',component:IndexComponent},
  {path:'',component:NabvarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
