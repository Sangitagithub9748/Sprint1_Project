package com.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars.config.HibernateUtil;
import com.ars.entity.TicketBooking;
import com.ars.model.TicketBookingDTO;
import com.ars.service.FlightService;
import com.ars.service.TicketService;
import com.ars.serviceImpl.TicketServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TicketTest {

	TicketService tService = new TicketServiceImpl();
	
	
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	@BeforeEach
	 void OpenSession()
	{
		session=sessionFactory.openSession();
	}
	
	@AfterEach
	void closeSession()
	{
		if(session!= null)
			session.close();
		System.out.println("Session closed");
	}
	
	@AfterAll
	static void tearDown()
	{
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session factory closed");
	}
	//testing method for book flight
//	@Test
	//@Order(1)
//	void testBookFlight()
//	{
//		TicketBookingDTO tdto = tService.bookFlight(5, 3, LocalDate.parse("2022-10-25"), "shawin@gmail.com", "Indigo");
//		assertNotNull(tdto);
//	}
	//testing method for cancel booking
//	@Test
	//@Order(2)
//	void testCancelBooking()
//	{
//		tService.cancelBooking(30197);
//		assertThrows(Exception.class, ()->tService.getTicket(30197));
//	}
	//testing method for get flight ticket
	//@Order(3)
//	@Test
//	void testGetTicket()
//	{
//		TicketBookingDTO tdto = tService.getTicket(68194) ;
//		assertEquals(tdto.getTicketId(), 68194);
//	}

}