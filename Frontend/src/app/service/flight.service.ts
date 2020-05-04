import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{ Flight } from '../model/filght.model'
import { Ticket } from '../model/ticket.model';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  baseUrl: string = "http://localhost:9092/FlightBookingSystem/";
  static bookflight :Flight;

  constructor(private http: HttpClient) { }
 
  setBookFlight(flight :Flight){
    FlightService.bookflight = flight;
   }
   getBookFlight(){
     return FlightService.bookflight;
   }

  successfullSearch(source, destination){
    return this.http.get<Flight[]>(this.baseUrl + "searchFlight/" +source+ "/" +destination);
  }

  bookSeat(id,userId){
    return this.http.get<Flight[]>(this.baseUrl + "bookFlight/" +id+"/"+userId );
  }

  getAllTickets(userId){
    return this.http.get<Ticket[]>(this.baseUrl + "allTickets/" +userId);
  }
  viewTickets(userId:number){
   
    return this.http.get<Ticket[]>(this.baseUrl + "allTickets/" +userId);
  }

  cancelTicket(TicketId:number){
    return this.http.get(this.baseUrl+ "cancelFlight/" +TicketId);
  }

}
