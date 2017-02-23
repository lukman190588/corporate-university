import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { SharedModule } from './shared/shared.module';
import { AppComponent } from './app.component';

import { LoginComponent } from './shared/login/login.component';
import { HomeComponent } from './shared/home/home.component';

import { AuthGuard } from './shared/auth.guard';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "**", component: HomeComponent }
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    SharedModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ AuthGuard ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
