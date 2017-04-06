import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    LoginRoutingModule,
    FormsModule,
    CommonModule
  ],
  declarations: [LoginComponent,
  ]
})
export class LoginModule { }
