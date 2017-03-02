import { Injectable } from '@angular/core';
import { CanActivate, CanActivateChild, Router } from '@angular/router';

import { AuthService } from './auth.service';

@Injectable()
export class CekLoginGuard implements CanActivate, CanActivateChild {

    constructor(private auth: AuthService, private router: Router) { }
    
canActivate() {
    console.log('AuthGuard#canActivate called');
	if(!this.auth.sudahLogin()) {
		this.router.navigate(['/admin/login']);
		return false;
	}
    return true;
  }

  canActivateChild() {
	  console.log('AuthGuard#canActivateChild called');
      return this.canActivate();
}
}