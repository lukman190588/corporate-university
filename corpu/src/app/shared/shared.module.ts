import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';

import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';

import { AuthService } from './auth.service';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "**", component: HomeComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  providers: [ AuthService ],
  declarations: [LoginComponent, RegisterComponent, HomeComponent, NavbarComponent, FooterComponent]
})
export class SharedModule { }
