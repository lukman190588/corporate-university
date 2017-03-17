import { Injectable } from '@angular/core';
import { AuthHttp } from 'angular2-jwt';
import { UserTable } from './model/UserTable';

@Injectable()
export class AdminserviceService {

  constructor(public authHttp: AuthHttp) { }

  getAllUser(): Promise<UserTable[]> {
    let userUrl = "/api/user/getAllUser";
    console.log("Menjalankan service getalluser");
    return this.authHttp.get(userUrl)
      .toPromise()
      .then(
      response => response.json() as UserTable[]
      )
      .catch(this.handleError);
  }

  saveUser(usr: UserTable): Promise<String> {
    let url: string = "/api/user/saveUser";
    console.log("Menyimpan user : " + JSON.stringify(usr));
    this.authHttp.post(url, usr).toPromise()
      .then(hasil => hasil.status)
      .catch(error => console.log(error));
    return Promise.resolve("success");
  }

  // getHeroes(): Promise<Hero[]> {
  //   return this.http.get(this.heroesUrl)
  //              .toPromise()
  //              .then(response => response.json().data as Hero[])
  //              .catch(this.handleError);
  // }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
