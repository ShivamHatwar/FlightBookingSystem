import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from 'src/app/service/flight.service';
import { Ticket } from 'src/app/model/ticket.model';
import { Flight } from '../../model/filght.model'
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-view-ticket',
  templateUrl: './view-ticket.component.html',
  styleUrls: ['./view-ticket.component.css']
})
export class ViewTicketComponent implements OnInit {

  tickets: Ticket[]=[];
  
  constructor(private formBuilder: FormBuilder,private router: Router,
    private flightService: FlightService) { }

  ngOnInit() {
    if (localStorage.username == null) {
      this.router.navigate(['/login']); 
    }
    this.flightService.viewTickets(sessionStorage.userid).subscribe(data=>{
      if(data){
      this.tickets = data;
      console.log(this.tickets);
      }else{
        alert(`No Ticket is booked yet`);
      }
    })
    }
    
  
cancel(bookingId: number){
  console.log(bookingId)
  this.flightService.cancelTicket(bookingId).subscribe(data =>{
    console.log(data);
    alert(`Ticket Cancelled`);
    this.flightService.viewTickets(sessionStorage.userid).subscribe(data =>{
      this.tickets=data;
      console.log(this.tickets);
    })
  })
}
logOutUser(){
  localStorage.clear();
  sessionStorage.clear();
  this.router.navigate(['/login']);
}

backToList(){
  this.router.navigate(['/list-operation'])
}
}
