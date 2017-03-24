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
  user: UserTable = new UserTable();
  message: string = "Data tidak valid!";

  constructor(private adminservice: AdminserviceService, private authService: AuthService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.save();
  }

  save(): void {
    console.log(this.user);
    if (this.user.id != null
      && this.user.username != null
      && this.user.email != null
      && this.user.fullname != null) {
      this.user.id = "1";
      this.adminservice.saveUser(this.user).then(hasil => {
        console.log("User berhasil disimpan");
        this.user = new UserTable();
      });
      this.reset();
    } else {
      console.log("Batal");
    }
    console.log(this.user);
  }

  reset(): void {
    this.user.id = "";
    this.user.username = "";
    this.user.email = "";
    this.user.password = "";
    this.user.fullname = "";
  }
}
