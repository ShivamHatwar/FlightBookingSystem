import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from '../model/users.model';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl: string = "http://localhost:9092/FlightBookingSystem/";
  constructor(private http : HttpClient) { }

 
  createNewUser(user: Users) {
    return this.http.post(this.baseUrl+"add-user", user, { responseType: 'text' as 'json'});
  }

  successfullLogin(username, password){
    return this.http.get(this.baseUrl + "login/" +username+ "/" +password);
  }
  
}
