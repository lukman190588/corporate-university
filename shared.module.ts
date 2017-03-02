import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AuthService } from './auth.service';
import { SharedComponent } from './shared.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';

import { AuthGuard } from './auth.guard';
import { EventComponent } from './event/event.component';

const routes: Routes = [
  { path: "dashboard", component: DashboardComponent },
  { path: "event", component: DashboardComponent },
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild(routes)
  ],
  providers: [AuthService, AuthGuard],
  declarations: [SharedComponent, DashboardComponent, SidebarComponent, NavbarComponent, EventComponent]
})
export class SharedModule { }
