import { Injectable } from '@angular/core';
import { AuthHttp } from 'angular2-jwt';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';

import { UserTable } from './model/UserTable';
import { TblEvents } from './model/TblEvents';
import { TblEventsResponse } from './model/TblEventsResponse';
import { Observable } from 'rxjs/Rx';
@Injectable()
export class AdminserviceService {

  constructor(public authHttp: AuthHttp, private http: Http) { }

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

  getAsyncEvents(pageSize: number, page: number): Promise<TblEventsResponse> {
    let params: URLSearchParams = new URLSearchParams();
    params.set('pageSize', pageSize + "");
    params.set('pageNumber', page + "");

    let requestOptions = new RequestOptions();
    requestOptions.search = params;
    let userUrl = "/api/events/getAllEventsPaged";
    return this.authHttp.get(userUrl, requestOptions)
      .toPromise()
      .then(
      response => response.json() as TblEventsResponse
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

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
