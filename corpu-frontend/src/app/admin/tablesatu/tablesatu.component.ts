import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { UserTable } from '../model/UserTable';
import { AuthService } from './../../shared/auth.service';

@Component({
  selector: 'app-tablesatu',
  templateUrl: './tablesatu.component.html',
  styleUrls: ['./tablesatu.component.scss']
})
export class TablesatuComponent implements OnInit {
  dataUser: UserTable[];

  constructor(private adminservice: AdminserviceService, private authService: AuthService) { }

  ngOnInit() {
    this.bindAllUsers();
  }

  bindAllUsers() {
    console.log("Bind Users")
    this.adminservice.getAllUser()
      .then(
      hasil => {
        this.dataUser = hasil;
        console.log(this.dataUser[0]);
      }
      );
  }

}
