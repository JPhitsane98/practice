import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Micro4Component } from './micro4/micro4.component';

const routes: Routes = [
  { path: 'calculator', redirectTo: 'http://127.0.0.1:8080/financial-calculator/', pathMatch: 'full' },
  { path: 'employee', redirectTo: 'http://127.0.0.1:8080/employee-management/', pathMatch: 'full' },
  { path: 'todo', redirectTo: 'http://localhost:3000/', pathMatch: 'full' },
  { path: 'micro4', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class Routes { }
