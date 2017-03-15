import { Http, RequestOptions, HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';
import { AuthHttp, AuthConfig } from 'angular2-jwt';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';

import { AuthService } from './auth.service';

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig({
	  	tokenName: 'access_token'
	  }), http, options);
}

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
	HttpModule
  ],
  declarations: [],
  providers: [
  		AuthService,
		{
	      provide: AuthHttp,
	      useFactory: authHttpServiceFactory,
	      deps: [Http, RequestOptions]
	    }
	],
  exports: [  ]
})
export class SharedModule { }