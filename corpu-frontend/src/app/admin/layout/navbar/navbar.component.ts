import { SIDEBAR_TOGGLE_DIRECTIVES } from './../sidebar.directive';
import { AsideToggleDirective } from './../aside.directive';
import { NgModule } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './../../../shared/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'navigation-bar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

@NgModule({
  declarations: [
    SIDEBAR_TOGGLE_DIRECTIVES,
    AsideToggleDirective,
  ]
})

export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  public disabled:boolean = false;
  public status:{isopen:boolean} = {isopen: false};

  public toggled(open:boolean):void {
  }

  public toggleDropdown($event:MouseEvent):void {
    $event.preventDefault();
    $event.stopPropagation();
    this.status.isopen = !this.status.isopen;
  }


  ngOnInit() {
  }

  currentUser() {
    return this.authService.getUserInfo();
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/admin/login']);
  }

}
