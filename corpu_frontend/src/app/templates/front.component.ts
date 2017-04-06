import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-front',
  templateUrl: './front.component.html'
})
export class FrontComponent implements OnInit {
  returnUrl: string;

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

}
