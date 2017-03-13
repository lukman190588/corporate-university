import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styles: [`.router-link-active { 
    color:#ffffff;
    font-weight:bold;
    text-decoration: none;
  }`]
})
export class NavComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  goTo(location: string): void {
    window.location.hash = location;
  }

}
