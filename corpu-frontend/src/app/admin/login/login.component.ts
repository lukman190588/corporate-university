import { AuthService } from './../../shared/auth.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
	templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

	username: string = "user001";
	password: string = "u00123";

	constructor(private authService: AuthService, private router: Router) { }

	ngOnInit() {
	}

	login(): void {
		console.log("Username : " + this.username);
		console.log("Password : " + this.password);
		this.authService.login(this.username, this.password)
			.then(sukses => {
				if (sukses) {
					this.router.navigate(['/admin/dahsboard']);
				} else {
					console.log("Login gagal");
				}
			});
	}

	redirectSite(): void {
		this.router.navigate(['/']);
	}

}
