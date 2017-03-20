import { Component, Input, OnInit } from '@angular/core';

import { AdminserviceService } from '../adminservice.service';
import { AuthService } from './../../shared/auth.service';

import { TblEvents } from '../model/TblEvents';

@Component({
  selector: 'app-tabledua',
  templateUrl: './tabledua.component.html',
  styleUrls: ['./tabledua.component.scss'],
})
export class TableduaComponent implements OnInit {
  events: TblEvents[];
  pageSize: number = 10;
  p: number;
  total: number;
  loading: boolean;

  constructor(private adminservice: AdminserviceService, private authService: AuthService) { }

  ngOnInit() {
    this.getPage(1);
  }

  getPage(page: number) {
    this.loading = true;
    this.adminservice.getAsyncEvents(this.pageSize, page)
      .then(
      hasil => {
        this.events = hasil.items;
        this.total = hasil.total;
        this.loading = false;
      });
  }

}