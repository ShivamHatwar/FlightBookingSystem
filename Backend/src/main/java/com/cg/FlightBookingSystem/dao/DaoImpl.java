package com.cg.FlightBookingSystem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.cg.FlightBookingSystem.advice.AppsExceptionHandler;
import com.cg.FlightBookingSystem.advice.LoggerAdvice;
import com.cg.FlightBookingSystem.entity.Flight;
import com.cg.FlightBookingSystem.entity.Ticket;
import com.cg.FlightBookingSystem.entity.Users;
import com.cg.FlightBookingSystem.service.ServiceImpl;

@Repository
public class DaoImpl implements IDao {
	
	private Logger logger = LoggerAdvice.getLogger(DaoImpl.class);
	public DaoImpl() {
	}

	@Autowired
	private EntityManager entityManager;
	@Override
	public boolean addUser(Users s)   {
		String methodName = "addUser()";
		logger.info(methodName + " called from Dao");
		try {
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(s);
		return true;
		}
		catch(HibernateException e) {
			throw new HibernateException("");
		}
		
	}

	@Override
	public int isUser(String username, String password)  {
		String methodName = "isUser()";
		logger.info(methodName + " called from Dao");

		String command = "select ud.user_Id from Users ud where ud.username = :uName and ud.password = :pass";
		TypedQuery<Integer> query = entityManager.createQuery(command,Integer.class);
		query.setParameter("uName", username);
		query.setParameter("pass", password);
		Integer uid ;
		uid = query.getSingleResult();
		return uid;

		}

	@Override
	public void addFlight(Flight f) {
		String methodName = "addFlight()";
		logger.info(methodName + " called from Dao");
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(f);
		
	}

	@Override
	public void updateFlight(Flight f) {
		String methodName = "updateFlight()";
		logger.info(methodName + " called from Dao");
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(f);
	}

	@Override
	public Flight getFlight(int flightId) {
		
		String methodName = "getFlight()";
		logger.info(methodName + " called from Dao");
		
		String qStr = "SELECT f FROM Flight f WHERE f.flightId=:fId";
		TypedQuery<Flight> query = entityManager.createQuery(qStr, Flight.class);
		query.setParameter("fId", flightId);
		Flight flight = query.getSingleResult();

		return flight;
	}

//	@Transactional
	@Override
	public List<Flight> searchFlight(String source, String dest) {
		String methodName = "searchFlight()";
		logger.info(methodName + " called from Dao");
		source = source.toUpperCase();
		dest = dest.toUpperCase();
		try {
			String command = "select fd from Flight fd where fd.source = :from and fd.destin = :to";
			TypedQuery<Flight> query = entityManager.createQuery(command,Flight.class);
			query.setParameter("from", source);
			query.setParameter("to", dest);
			
			Flight flight;
//			flight = query.getSingleResult();
//			System.out.println("Flight= "+flight.getFlightId() + " Source= "+flight.getSource());
			
			List<Flight> flightList = query.getResultList();
			
			return flightList;
			}
			catch (Exception e) {
				
				throw new NullPointerException();
			}
	}

	@Override
	public boolean bookFlight(Ticket tc) {
		String methodName = "bookFlight()";
		logger.info(methodName + " called from Dao");
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(tc);
		return true;
	}

	@Override
	public List<Ticket> viewTicket(int userId) {
		String methodName = "viewTIcket()";
		logger.info(methodName + " called from Dao");
		
		String command = "select tc from Ticket tc where USER_ID = :uid";
		TypedQuery<Ticket> query = entityManager.createQuery(command,Ticket.class);
		query.setParameter("uid", userId);
		return query.getResultList();
	}

	@Override
	public boolean cancelTicket(Ticket bd) {
		String methodName = "cancelTicket()";
		logger.info(methodName + " called from Dao");
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(bd);
		cs.delete(bd);
	
		return true;
	}

	@Override
	public Ticket getTicketDetails(int TicketId) {
		String methodName ="getTicket()";
		logger.info(methodName + " called from Dao");
		return entityManager.find(Ticket.class, TicketId);
	}

	@Override
	public List<Flight> getAllFlight() {
		String methodName = "getAllFlight()";
		logger.info(methodName + " called from Dao");
		String command= "Select fd from Flight fd";
		TypedQuery<Flight> query = entityManager.createQuery(command,Flight.class);
		List<Flight> flightList = query.getResultList();
		return flightList;
	}
	
}
