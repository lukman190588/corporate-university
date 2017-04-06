import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './../shared/auth.service';

@Component({
  selector: 'pegadaian-corpu',
  templateUrl: './admin.component.html'
})
export class AdminComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  public disabled: boolean = false;
  public status: { isopen: boolean } = { isopen: false };

  public toggled(open: boolean): void {
    console.log('Dropdown is now: ', open);
  }

  public toggleDropdown($event: MouseEvent): void {
    $event.preventDefault();
    $event.stopPropagation();
    this.status.isopen = !this.status.isopen;
  }

  doRefreshPage() {
    this.router.navigate(['/admin/login']);
  }

  cekPage(): boolean {
    if (this.router.url != '/admin/login' && !this.authService.sudahLogin()) {
      return true;
    } else {
      return false;
    }
  }

  ngOnInit(): void {
    console.log(this.cekPage());
  }
}
