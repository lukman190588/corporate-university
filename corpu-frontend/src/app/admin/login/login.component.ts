import { AuthService } from './../../shared/auth.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
	templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

	username: string = "user001";
	password: string = "u00123";
	isValid: boolean = true;
	errorMessage: string = "";

	constructor(private authService: AuthService, private router: Router) { }

	ngOnInit() {
	}

	login(): void {
		this.isValid = true;
		console.log("Username : " + this.username);
		console.log("Password : " + this.password);
		this.authService.login(this.username, this.password)
			.then(sukses => {
				console.log("Proses Login");
				this.isValid = sukses;
				console.log(this.isValid);
				if (this.isValid) {
					this.router.navigate(['/admin/dashboard']);
				} else {
					console.log("Login gagal");
					this.errorMessage = "Username atau Password salah.";
				}
			},
			error => {
				this.handleError;
				this.errorMessage = error.message;
			});
	}

	redirectSite(): void {
		this.router.navigate(['/']);
	}

	handleError(error: any) {
		// In a real world app, you might use a remote logging infrastructure
		let errMsg: string;
		errMsg = error.message ? error.message : error.toString();
		console.error("Login Error");
		return errMsg;
	}
}
