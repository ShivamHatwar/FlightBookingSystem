package com.cg.FlightBookingSystem.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAdvice {

	public static Logger getLogger(Class className) {
		return LoggerFactory.getLogger(className);
	}
	
}
