import { Component, OnInit } from '@angular/core';
import { Flight } from '../../model/filght.model';
import { Router } from '@angular/router';
import { FlightService } from 'src/app/service/flight.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-book-ticket',
  templateUrl: './book-ticket.component.html',
  styleUrls: ['./book-ticket.component.css']
})
export class BookTicketComponent implements OnInit {

  searchFlight: FormGroup;
  submitted: boolean = false;

  flights: Flight[] = [];
 
  constructor(private formBuilder: FormBuilder,
    private flightService: FlightService, private router: Router) { }

  ngOnInit() {
    if (localStorage.username == null) {
      this.router.navigate(['/login']);

    }
    this.searchFlight = this.formBuilder.group({
      source: ['', Validators.required],
      destination: ['', Validators.required]
    });
  }

  searchFlightFromTo() {
    this.submitted = true;
    if (this.searchFlight.invalid) {
      return;
    }
    let source = this.searchFlight.controls.source.value;
    let destination = this.searchFlight.controls.destination.value;

    this.flightService.successfullSearch(source, destination).subscribe(data => {
      if (data) {
        this.flights = data;
        console.log(data);
      } else {
        alert(`No flight avaliable from ${source} to ${destination} try with different location..!`);
      }

    }, err => {
      console.log(err);
    });
  }

  // logOutUser() function
  logOutUser() {

    sessionStorage.clear();
    this.router.navigate(['/login']);

  }

  bookTicket(selectedFlight: any) {
    this.flightService.setBookFlight(selectedFlight);
    console.log(selectedFlight);
    this.router.navigate(['/bookingPrompt']);
    // this.flightService.bookSeat(flight.flightId).subscribe(data => {
    //   if(data){
    //     alert(` Ticket is booked successfully ..!`);
    //   }
    // })

  }
  backToList() {
    this.router.navigate(['list-operation'])
  }

}
