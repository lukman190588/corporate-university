import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'pegadaian-corpu',
  templateUrl: './admin.component.html'
})
export class AdminComponent implements OnInit {

  constructor() { }

  public disabled:boolean = false;
  public status:{isopen:boolean} = {isopen: false};

  public toggled(open:boolean):void {
    console.log('Dropdown is now: ', open);
  }

  public toggleDropdown($event:MouseEvent):void {
    $event.preventDefault();
    $event.stopPropagation();
    this.status.isopen = !this.status.isopen;
  }

  ngOnInit(): void {}
}