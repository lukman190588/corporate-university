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
  collection: any[] = [
    { name: 'Austin', gender: 'Male', company: 'Swimlane' },
    { name: 'Dany', gender: 'Male', company: 'KFC' },
    { name: 'Molly', gender: 'Female', company: 'Burger King' },
  ];

  rows = [
    { name: 'Austin', gender: 'Male', company: 'Swimlane' },
    { name: 'Dany', gender: 'Male', company: 'KFC' },
    { name: 'Molly', gender: 'Female', company: 'Burger King' },
  ];
  columns = [
    { prop: 'name' },
    { name: 'Gender' },
    { name: 'Company' }
  ];

  constructor(private adminservice: AdminserviceService, private authService : AuthService) { }

  ngOnInit() {
    console.log("Masuk init")
    this.adminservice.getAllUser()
      .then(
      hasil => this.dataUser = hasil,
      () => console.log(this.dataUser),
    );
  }

}
