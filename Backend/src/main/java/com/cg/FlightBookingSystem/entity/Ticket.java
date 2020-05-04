package com.cg.FlightBookingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "ticket")
public class Ticket {
	
	@Id
	@Column(name = "Ticket_Id")
	private int ticketId;
	

	@ManyToOne
	@JoinColumn(name = "id")
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;
	
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}



	public Ticket(int ticketId, Flight flight, Users user) {
		this.ticketId = ticketId;
		this.flight = flight;
		this.user = user;
	}

	public Ticket() {
		
	}

}
