import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'main',
  loadChildren: 'app/main/main.module#MainModule',
 },
  { path: '',   redirectTo: '/main', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: true, // <-- debugging purposes only
      }
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
