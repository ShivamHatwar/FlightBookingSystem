import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../service/user.service'



@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  addForm: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder,
    private router: Router, private userService: UserService) { }
  // constructor(private formBuilder: FormBuilder,
  //   private router: Router) { }

  ngOnInit() {
      this.addForm = this.formBuilder.group({
         name: ['', [Validators.required,Validators.pattern("[A-Z][a-z]{2,14}")]],
        username: ['', Validators.required],
         age: ['', [Validators.required, Validators.min(15), Validators.max(90)]],
         mobileNum: ['', [Validators.required, Validators.pattern("[6-9][0-9]{9}")]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.pattern("[A-Z]{1}[a-z]{1}[a-zA-Z0-9]{4,8}")]]
      });
    
   
    
  }

  // addUser() function
  addUser() {


    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }

    // on successful validations, execute below code snippet

    console.log(this.addForm.value);

    this.userService.createNewUser(this.addForm.value).subscribe(data => {
      alert(`${this.addForm.controls.name.value} record is added successfully ..!`);
      this.router.navigate(['login']);

    }, err => {
      console.log(err);
      console.log(err.stack);
    })

  }

}
