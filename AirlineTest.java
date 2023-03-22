package com.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars.config.HibernateUtil;
import com.ars.dao.AirlineDao;
import com.ars.daoimpl.AirlineDAOImpl;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.exception.GlobalException;
import com.ars.model.AirlineDTO;
import com.ars.service.AirlineService;
import com.ars.service.FlightService;
import com.ars.serviceImpl.AirlineServiceImpl;
import com.ars.serviceImpl.FlightServiceImpl;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AirlineTest {

	FlightService flightService = new FlightServiceImpl();
	AirlineService airlineService = new AirlineServiceImpl();
	AirlineDao airDao =new AirlineDAOImpl();
	
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
	
	//testing for one to may relationship
	@Test	
	void OneToManyRelationshipTest()
	{
		Airline airline=Airline.builder().airlineName("Air india").fare(5000).build();
		
		Flight flight1=Flight.builder().airline(airline).availableSeats(10).date(LocalDate.of(2022, 10, 20)).
				destination("mumbai").source("kolkata").time("05:10").build();

		Flight flight2=Flight.builder().airline(airline).availableSeats(10).date(LocalDate.of(2022, 10, 20)).
				destination("delhi").source("kolkata").time("06:10").build();
		
		List<Flight> flights=new ArrayList<Flight>();
		flights.add(flight1);
		flights.add(flight2);
		
		airline.setFlights(flights);
		
		flightService.saveFlight(flight1);
		flightService.saveFlight(flight2);
		
		assertThat(flight1.getAirline()).isEqualTo(airline);
		assertThat(flight2.getAirline()).isEqualTo(airline);
		
		assertThat(airline.getFlights().get(0).getFlight_id()).isEqualTo(flight1.getFlight_id());
		assertThat(airline.getFlights().get(1).getFlight_id()).isEqualTo(flight2.getFlight_id());
	}
	//testing for save airline
//	@Test
	//@Order(1)
//	void testSaveAirline()
//	{
//		Transaction tx = session.beginTransaction();
//		Airline airline = Airline.builder().airlineName("Air india").fare(5000).build();
//		
//		Integer i = (Integer) session.save(airline);
//		tx.commit();
//		assertThat(i>0).isTrue();
//	}
	//testing for update airline
//		@Test
	//@Order(2)
//	void testUpdateAirlineUsingService()
//	{
//		Transaction tx=session.beginTransaction();
//		Airline a=new Airline();
//		a.setAirlineName("vistara");
//		a.setFare(5000.65f);
//		AirlineDTO pdto=airlineService.updateAirlneById(7, a);
//		tx.commit();
//		assertThat(pdto.getAirlineName()).isEqualTo("vistara");
//	}
	//testing for get  airline by name
//	@Test
//	void testGetAirlineNameByName()
//	{
//		AirlineDTO adto = airlineService.getAirlineByName("vistara");
//		assertThat(adto.getAirlineName()).isEqualTo("vistara");
//		
//	}
	
	//testing for delete airline
//	@Test
	//@Order(3)
//	void testDeleteAirline()
//{
//		airlineService.deleteAirline(7);
//		assertThrows(GlobalException.class, ()-> airlineService.getAirlineByName("vistara") );
//	}
//	
	//testing for assign airline to flight
//	@Test
	//@Order(4)
//	@DisplayName("Positive test case")
//	void testAssignAirlineToFlight()
//	{
//		airDao.assignAirlineToFlight(7,5);
//		assertThat(flightService.getFlight(7).getAirline().getAirlineName()).isEqualTo("Indigo");
//	}
	//testing for assign  airline to flight for negetive test case
//	@Test
	//@Order(5)
//	@DisplayName("Negetive test case")
//	void testAssignAirlineToFlight()
//	{
//		airDao.assignAirlineToFlight(6,6);
//		assertThat(flightService.getFlight(6).getAirline().getAirlineName()).isEqualTo("Spicejet");
//	}
}
