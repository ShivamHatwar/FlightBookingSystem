package com.cg.FlightBookingSystem.advice;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(HibernateException.class)
	public ResponseEntity<Object> exception1(Exception e) {

		ErrorMassage exceptionResponse = new ErrorMassage("Username Already exists", e.getLocalizedMessage());

		return new ResponseEntity<Object>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Object> exception2(Exception e) {

		ErrorMassage exceptionResponse = new ErrorMassage("Invalid Username or Password", e.getLocalizedMessage());

		return new ResponseEntity<Object>(exceptionResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> exception3(Exception e) {

		ErrorMassage exceptionResponse = new ErrorMassage("No Flight Avaliable on this ruote", e.getLocalizedMessage());

		return new ResponseEntity<Object>(exceptionResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exception(Exception e) {

		ErrorMassage exceptionResponse = new ErrorMassage("Something went wrong", e.getLocalizedMessage());

		return new ResponseEntity<Object>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}

class ErrorMassage {
	private String massage;
	private String details;

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ErrorMassage(String massage, String details) {
		this.massage = massage;
		this.details = details;
	}

}