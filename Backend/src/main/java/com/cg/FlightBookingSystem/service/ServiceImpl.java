package com.cg.FlightBookingSystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.FlightBookingSystem.ProjectController;
import com.cg.FlightBookingSystem.advice.LoggerAdvice;
import com.cg.FlightBookingSystem.dao.DaoImpl;
import com.cg.FlightBookingSystem.entity.Flight;
import com.cg.FlightBookingSystem.entity.Ticket;
import com.cg.FlightBookingSystem.entity.Users;

@Service
@Transactional
public class ServiceImpl {

	private Logger logger = LoggerAdvice.getLogger(ServiceImpl.class);

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private DaoImpl dao;
	private static int bookingId;

	@Transactional
//	@Override
	public boolean addUser(Users s)  {

		String methodName = "addUser()";
		logger.info(methodName + " called from service");
		return dao.addUser(s);

	}

//	@Override
	public int isUser(String username, String password)  {
		String methodName = "isUser()";
		logger.info(methodName + " called from service");
		return dao.isUser(username, password);
	}

	
//	@Override
	public List<Flight> searchFlight(String from, String to) {
		String methodName = "searchFlight()";
		logger.info(methodName + " called from service");
		return dao.searchFlight(from, to);
	}

	/*
	 * // @Override public List<Flight> getAllFlights() { // TODO Auto-generated
	 * method stub return null; }
	 */
//	@Override
	public Integer bookFlight(int id, int userId) {

		String methodName = "bookFlight()";
		logger.info(methodName+" called from service");
		Integer tempBD = bookingId;
		Ticket tc = new Ticket();
		Flight fd = dao.getFlight(id);
		if (fd.getAvaliableseats() > 0) {
			fd.setAvaliableseats(fd.getAvaliableseats() - 1);
			dao.updateFlight(fd);

			String command = "select count(bd.ticketId) from Ticket bd";
			TypedQuery<Long> query = entityManager.createQuery(command, Long.class);
			long count = query.getSingleResult();
			if (count > 0) {
				command = "select max(bd.ticketId) from Ticket bd";
				TypedQuery<Integer> query2 = entityManager.createQuery(command, Integer.class);
				Integer bid = query2.getSingleResult();
				tempBD = bid + 1;
			} else {
				tempBD = 1001;
			}

			command = "select user from Users user where user.user_Id =: puserid";
			TypedQuery<Users> query2 = entityManager.createQuery(command, Users.class);
			query2.setParameter("puserid", userId);

			Users user = query2.getSingleResult();
			tc.setTicketId(tempBD);
			tc.setUser(user);
			tc.setFlight(fd);

			if (dao.bookFlight(tc)) {
				return tempBD;
			}
		} else {
			System.out.println("No booking available");
		}
		return 0;

	}

	public boolean cancelFlight(int ticketId) {

		String methodName = "cancelFlight()";
		logger.info(methodName+" called from service");
		
		String qStr = "SELECT t FROM Ticket t WHERE Ticket_Id =: bId";
		TypedQuery<Ticket> query = entityManager.createQuery(qStr, Ticket.class);
		query.setParameter("bId", ticketId);
		Ticket bd = query.getSingleResult();

		if (bd != null) {
			int availableSeats = bd.getFlight().getAvaliableseats() + 1;
			bd.getFlight().setAvaliableseats(availableSeats);

			dao.cancelTicket(bd);
			return true;
		} else {
			return false;
		}

	}

//	@Override
	public List<Ticket> viewTickects(int user_id) {
		
		String methodName = "viewTickets()";
		logger.info(methodName+" called from service");
		
		List<Ticket> myTickets = dao.viewTicket(user_id);

		return myTickets;
	}

//	@Override
//	public Flight getFlight(int id) {
//		String methodName = "getFlight()";
//		logger.info(methodName+" called from service");
//		return null;
//
//	}

}
