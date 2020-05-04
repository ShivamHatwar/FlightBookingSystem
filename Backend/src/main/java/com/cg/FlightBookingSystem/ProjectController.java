package com.cg.FlightBookingSystem;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FlightBookingSystem.advice.LoggerAdvice;
import com.cg.FlightBookingSystem.entity.Flight;
import com.cg.FlightBookingSystem.entity.Ticket;
import com.cg.FlightBookingSystem.entity.Users;
import com.cg.FlightBookingSystem.service.ServiceImpl;

@RestController
@RequestMapping(value = "/FlightBookingSystem")
public class ProjectController {

	private Logger logger = LoggerAdvice.getLogger(ProjectController.class);

	@Autowired
	ServiceImpl fbs;

	@CrossOrigin(origins = "*")
	@PostMapping("/add-user")
	public boolean addUser(@RequestBody Users users) {
		String methodName = "addUser()";
		logger.info(methodName + " called");
		return fbs.addUser(users);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/login/{username}/{password}")
	public int isUser(@PathVariable String username, @PathVariable String password)  {

		String methodName = "isUser()";
		logger.info(methodName + " called");
		return fbs.isUser(username, password);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/searchFlight/{source}/{dest}")
	public List<Flight> searchFlight(@PathVariable String source, @PathVariable String dest) {
		String methodName = "searchFlight()";
		logger.info(methodName + " called");
		return fbs.searchFlight(source, dest);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/bookFlight/{id}/{userId}")
	public Integer bookFlight(@PathVariable Integer id, @PathVariable Integer userId) {
		String methodName = "bookFlight()";
		logger.info(methodName + " called");
		return fbs.bookFlight(id, userId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/allTickets/{user_Id}")
	public List<Ticket> getTickets(@PathVariable Integer user_Id) {
		String methodName = "getTicket()";
		logger.info(methodName + " called");
		return fbs.viewTickects(user_Id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/cancelFlight/{ticketId}")
	public boolean cancelFlight(@PathVariable Integer ticketId) {
		String methodName = "cancelFlight()";
		logger.info(methodName + " called");
		return fbs.cancelFlight(ticketId);
	}
}
