package com.cg.FlightBookingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@Column(name="FLIGHTID")
	private int flightId;
	
	@Column(name="Source")
	private String source;
	
	@Column(name="Destin")
	private String destin;
	
	@Column(name="TimeB")
	private String timeB;
	
	@Column(name="Avaliable_Seats")
	private int avaliableseats;
	
	@Column(name="Price")
	private int price;

	public Flight() {
	}

	public Flight(int flightId, String source, String destin, String timeB, int avaliableseats, int price) {
		this.flightId = flightId;
		this.source = source;
		this.destin = destin;
		this.timeB = timeB;
		this.avaliableseats = avaliableseats;
		this.price = price;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestin() {
		return destin;
	}

	public void setDestin(String destin) {
		this.destin = destin;
	}

	public String getTimeB() {
		return timeB;
	}

	public void setTimeB(String timeB) {
		this.timeB = timeB;
	}

	public int getAvaliableseats() {
		return avaliableseats;
	}

	public void setAvaliableseats(int avaliableseats) {
		this.avaliableseats = avaliableseats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
