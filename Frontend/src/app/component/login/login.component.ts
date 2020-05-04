import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [NgbCarouselConfig]
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean= false;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private userService: UserService,config:NgbCarouselConfig) {
      config.interval = 5000;
    config.wrap = true;
    config.keyboard = true;
    config.pauseOnHover=false;
     }

  ngOnInit() {
    localStorage.clear();
    sessionStorage.clear();
    
    
    this.loginForm = this.formBuilder.group({
      username:['',Validators.required],
      password: ['', Validators.required]
    });
  }

  verifyLogin(){
    this.submitted = true;
    if(this.loginForm.invalid){
      return;
    }

    let username = this.loginForm.controls.username.value;
    let password = this.loginForm.controls.password.value;

    console.log(username + password);
    this.userService.successfullLogin(username,password).subscribe(data =>{
      console.log(data);
      if(data){
        localStorage.username = username;
        localStorage.userid = data;
        sessionStorage.userid = data;
        // sessionStorage.username = username;
        this.router.navigate(['list-operation'])
      }
    else{
      console.log("invalid login");
      alert(`Invalid username or password`);
      this.invalidLogin = true;
    }
    },
      err => {
        alert(`Invalid Username or password..!`);
        console.log(err.stack);
        console.log(err);
      });
  } 

  invalidLogin:boolean = false;
}

