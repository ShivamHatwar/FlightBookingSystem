package com.cg.FlightBookingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.FlightBookingSystem.entity.Flight;
import com.cg.FlightBookingSystem.entity.Ticket;
import com.cg.FlightBookingSystem.entity.Users;

public interface IDao{

	public boolean addUser(Users s) throws Exception ;
	
	int isUser(String username, String password) throws Exception;
	
	public void addFlight(Flight f);
	
	void updateFlight(Flight f);
	
	Flight getFlight(int flightId);
	
	List<Flight> searchFlight(String from,String to);
	
	List<Flight> getAllFlight();
	
	public boolean bookFlight(Ticket tc);
	
	List<Ticket> viewTicket(int userId);
	
	boolean cancelTicket(Ticket bd);
	
	Ticket getTicketDetails(int TicketId);
//	boolean addBooking(Booking bd);


}
