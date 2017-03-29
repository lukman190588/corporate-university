import { Injectable } from '@angular/core';
import { AuthHttp } from 'angular2-jwt';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';

import { UserTable } from './model/UserTable';
import { TblEvents } from './model/TblEvents';
import { TblEventsResponse } from './model/TblEventsResponse';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/timeout';
import 'rxjs/add/observable/throw';

@Injectable()
export class AdminserviceService {

  constructor(public authHttp: AuthHttp, private http: Http) { }

  getAllUser(): Observable<UserTable[]> {
    let userUrl = "/api/user/getAllUser";
    console.log("Menjalankan service getalluser");
    return this.authHttp.get(userUrl)
      .map(response => response.json() as UserTable[])
      .catch(this.handleError);
  }

  getAllEvents(pageSize: number, page: number): Observable<TblEventsResponse> {
    let params: URLSearchParams = new URLSearchParams();
    params.set('pageSize', pageSize + "");
    params.set('pageNumber', page + "");

    let requestOptions = new RequestOptions();
    requestOptions.search = params;
    let userUrl = "/api/events/getAllEventsPaged";
    return this.authHttp.get(userUrl, requestOptions)
      .timeout(2000)
      .map(
      response => response.json() as TblEventsResponse
      )
      .catch(this.handleError);
  }

  saveUser(usr: UserTable): Observable<UserTable> {
    let url: string = "/api/user/saveUser";
    console.log("Menyimpan user : " + JSON.stringify(usr));
    return this.authHttp.post(url, usr)
      .map(hasil => hasil.status)
      .catch(this.handleError);
  }

  saveEvents(event: TblEvents): Observable<TblEvents> {
    let url: string = "/api/event/saveEvent";
    console.log("Menyimpan event : " + JSON.stringify(event));
    return this.authHttp.post(url, event)
      .map(hasil => hasil.status)
      .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
