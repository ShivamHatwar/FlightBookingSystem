import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Flight } from 'src/app/model/filght.model';
import { FlightService } from 'src/app/service/flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-prompt',
  templateUrl: './booking-prompt.component.html',
  styleUrls: ['./booking-prompt.component.css']
})
export class BookingPromptComponent implements OnInit {
  bookForm: FormGroup;
  invalidLogin: boolean = false;
  isValidUser: boolean = false;
  submitted: boolean = false;
  flight: Flight;
  constructor(private formBuilder: FormBuilder, private router: Router,
    private flightService: FlightService) { }

  ngOnInit() {
    if (localStorage.username == null) {
      this.router.navigate(['/login']); 
    }
    this.bookForm = this.formBuilder.group({
    flightid: ['', Validators.required],
    // userid: ['', Validators.required]
  });
this.flight = this.flightService.getBookFlight();

  }

  payment(){
    alert(`Make Payment..`);

    this.flightService.bookSeat(this.flight.flightId,sessionStorage.userid).subscribe(data =>{
      console.log(data);
      alert(`Booking Successful Booking Id = ${data}`);
      this.router.navigate(['/list-operation']);
    }, err =>{
      console.log(err.stack())
      console.log(err);
    }
      )
  }

  cancel(){
    this.router.navigate(['/bookTicket'])
  }
}
