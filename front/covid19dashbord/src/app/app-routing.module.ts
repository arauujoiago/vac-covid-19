import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainDashbordComponent} from './main-dashbord/main-dashbord.component';
import {AppComponent} from "./app.component";

const routes: Routes = [
  { path: 'main-dashbord', component: MainDashbordComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
