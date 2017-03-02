import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-404',
  templateUrl: './404.component.html'
})
export class p404Component implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  	redirectSite(): void {
		this.router.navigate(['/']);
	}

}
