package com.cg.FlightBookingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.FlightBookingSystem.advice.LoggerAdvice;
import com.cg.FlightBookingSystem.entity.Flight;
import com.cg.FlightBookingSystem.entity.Ticket;
import com.cg.FlightBookingSystem.entity.Users;
import com.cg.FlightBookingSystem.service.ServiceImpl;

@SpringBootTest
class FlightBookingSystemApplicationTest {

	@Test
	void contextLoads() {
	}

	private static Logger logger = LoggerAdvice.getLogger(FlightBookingSystemApplicationTest.class);

	@Autowired
	ServiceImpl flightService;

	@BeforeAll
	static void setUpBeforeClass() {
		logger.info("SetUpClass method called");
	}

	@BeforeEach
	void setUp() {

		logger.info("Test started");
	}

	@AfterEach
	void afterEach() {

		logger.info("Test over");
	}
	
	@Test
	@DisplayName("User Login test 1")
	@Rollback(true)
	public void loginTest1() {
		String methodName = "IsUser()";
		logger.info(methodName+ " called");
		
		int value = flightService.isUser("Shivam12", "Shivam12");
		assertNotEquals(0, value);
	}
	
	@Test
	@DisplayName("User Login test 2")
	@Rollback(true)
	public void loginTest2() {
		String methodName = "IsUser()";
		logger.info(methodName+ " called");
		
		int value = flightService.isUser("Shivam12", "Shivam12");
		assertEquals(141, value);
	}
	@Test
	@DisplayName("Booking Ticket")
	@Rollback(true)
	public void bookFlight() {
		String methodName = "bookFlight()";
		logger.info(methodName+ " called");
		
		int value = flightService.bookFlight(1, 142);
		assertEquals(true, value);
	}
	
	@Test
	@DisplayName("Create New User")
	@Rollback(true)
	public void createUser() {
		String methodName = "addUser()";
		logger.info(methodName+ " called");
		
		Users user = new Users();
		user.setName("Prabhanjan");
		user.setUsername("Prabhanjan12");
		user.setAge(23);
		user.setMobileNum(8421142903L);
		user.setEmail("prabhu@gmail.com");
		user.setPassword("Prabhu12");
//		user.setUser_id(101);
		
		boolean status = flightService.addUser(user);
		assertNotEquals(true, status);
	}
	@Test
	@DisplayName("cancel Flight")
	@Rollback(true)
	public void cancelFlight() {
		String methodName = "cancelFlight()";
		logger.info(methodName+ " called");
		
		boolean value = flightService.cancelFlight(1005);
		assertEquals(true, value);
	}
	
	@Test
	@DisplayName("Search Flight")
	@Rollback(true)
	public void searchFlight() {
		String methodName = "searchFlight()";
		logger.info(methodName+ " called");
		
		List<Flight> flight = flightService.searchFlight("PUNE", "MUMBAI");
		assertNotNull(flight);
	}
	@Test
	@DisplayName("View Ticket")
	@Rollback(true)
	public void viewTicket() {
		String methodName = "viewTicket()";
		logger.info(methodName+ " called");
		
		List<Ticket> tickets = flightService.viewTickects(141);
		assertNotNull(tickets);
	}
}
