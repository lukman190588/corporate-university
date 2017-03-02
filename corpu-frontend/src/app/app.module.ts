import { BreadcrumbsComponent } from './admin/layout/breadcrumb.component';
import { AsideToggleDirective } from './admin/layout/aside.directive';
import { SIDEBAR_TOGGLE_DIRECTIVES } from './admin/layout/sidebar.directive';
import { NAV_DROPDOWN_DIRECTIVES } from './admin/layout/nav-dropdown.directive';
import { AuthService } from './shared/auth.service';
import { CekLoginGuard } from './shared/ceklogin';
import { SharedModule } from './shared/shared.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { DropdownModule } from 'ng2-bootstrap/dropdown';

import { AppComponent } from './app.component';

// Routing Module
import { AppRoutingModule } from './app.routing';

// Layouts admin
import { AdminComponent } from './templates/admin.component';
import { NavbarComponent } from './admin/layout/navbar/navbar.component';
import { SidebarComponent } from './admin/layout/sidebar/sidebar.component';

// website
import { FrontComponent } from './templates/front.component';
import { NavComponent } from './front/nav/nav.component';
import { ContentComponent } from './front/content/content.component';
import { FooterComponent } from './front/footer/footer.component';

//page not found
import { p404Component } from './404/404.component';

//content
import { DahsboardComponent } from './admin/dahsboard/dahsboard.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
     NAV_DROPDOWN_DIRECTIVES,
    BreadcrumbsComponent,
    SIDEBAR_TOGGLE_DIRECTIVES,
    AsideToggleDirective,
    AdminComponent,
    DahsboardComponent,
    FrontComponent,
    NavbarComponent,
    NavComponent,
    ContentComponent,
    FooterComponent,
    p404Component
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    DropdownModule.forRoot(),
    SharedModule,
  ],
  providers: [CekLoginGuard, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }