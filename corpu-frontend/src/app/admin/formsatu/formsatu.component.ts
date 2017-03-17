import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { UserTable } from '../model/UserTable';
import { AuthService } from './../../shared/auth.service';
@Component({
  selector: 'app-formsatu',
  templateUrl: './formsatu.component.html',
  styleUrls: ['./formsatu.component.scss']
})
export class FormsatuComponent implements OnInit {
  user: UserTable = new UserTable();;

  constructor(private adminservice: AdminserviceService, private authService: AuthService) { }

  ngOnInit() {
  }

  save(): void {
    this.user.id = "1";
    this.adminservice.saveUser(this.user).then(hasil => {
      console.log("User berhasil disimpan");
      this.user = new UserTable();
    });
    this.reset();
  }

  reset(): void {
    this.user.id = "";
    this.user.username = "";
    this.user.email = "";
    this.user.password = "";
    this.user.fullname = "";
  }
}
