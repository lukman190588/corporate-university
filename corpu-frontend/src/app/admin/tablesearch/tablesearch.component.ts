import { Component, OnInit } from '@angular/core';

import { AdminserviceService } from '../adminservice.service';
import { AuthService } from './../../shared/auth.service';

import { TblEvents } from '../model/TblEvents';
import { ModalDirective } from 'ng2-bootstrap/modal';

@Component({
  selector: 'app-tablesearch',
  templateUrl: './tablesearch.component.html',
  styleUrls: ['./tablesearch.component.scss']
})
export class TablesearchComponent implements OnInit {
  selectedEvent: TblEvents;
  mode: string;

  eventQuery: TblEvents = new TblEvents;
  eventResult: TblEvents[] = [];
  pageSize: number = 10;
  p: number;
  total: number;
  loading: boolean = false;
  isError: boolean = false;
  errorMessage: string = "";

  constructor(private adminservice: AdminserviceService, private authService: AuthService) { }

  getPage(page: number) {
    this.eventResult = [];
    this.total = 0;
    this.loading = true;
    this.isError = false;
    this.adminservice.getAllEventsBy(this.pageSize, page, this.eventQuery.name, this.eventQuery.kelas, this.eventQuery.tahun)
      .subscribe(
      hasil => {
        this.eventResult = hasil.items;
        this.total = hasil.total;
        this.loading = false;
        console.log(this.total);
        if (this.total == 0) {
          this.isError = true;
          this.errorMessage = "Data Tidak Ditemukan!";
        }
      },
      error => {
        console.log(<any>error);
        this.isError = true;
        this.loading = false;
        this.errorMessage = "error 401 - Koneksi ke Server Timeout!";
      },
    );
  }

  doSearch() {
    this.getPage(1);
  }

  reset(): void {
    this.resetForm();
    this.eventResult = [];
    this.total = 0;
    this.loading = false;
  }

  resetForm() {
    this.eventQuery.kelas = "";
    this.eventQuery.tahun = "";
    this.eventQuery.name = "";
  }

  showModal(event: TblEvents, mode: string, obj: any) {
    console.log("Button Clicked!");
    this.selectedEvent = event;
    this.mode = mode;
    console.log("mode : " + mode);
    console.log(this.selectedEvent.id);
  }

  onSubmit(modalEdit: ModalDirective) {
    console.log(this.selectedEvent);
    if (this.selectedEvent.kelas != null && this.selectedEvent.tahun != null
      && this.selectedEvent.name != null && this.selectedEvent.startDate != null
      && this.selectedEvent.endDate != null && this.selectedEvent.batch != null
      && this.selectedEvent.groupEvent != null && this.selectedEvent.event != null
      && this.selectedEvent.method != null && this.selectedEvent.internal != null
      && this.selectedEvent.open != null && this.selectedEvent.quota != null
      && this.selectedEvent.totalTime != null && this.selectedEvent.provider != null
      && this.selectedEvent.place != null && this.selectedEvent.location != null
      && this.selectedEvent.pic != null && this.selectedEvent.cost != null
      && this.selectedEvent.result != null) {
      if (this.mode == "edit") {
        this.adminservice.saveEvents(this.selectedEvent).subscribe(
          hasil => {
            console.log("Mode Edit");
            this.selectedEvent = new TblEvents();
          }
        );
      } else if (this.mode == "delete") {
        console.log("Mode Delete");
        return;
      }
    } else {
      console.log("Batal");
      return;
    }
    modalEdit.hide();
    console.log(this.selectedEvent);
  }

  ngOnInit() {
  }

}
