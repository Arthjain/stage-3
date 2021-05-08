package com.cognizant;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.exception.InvalidFlightOperationException;
import com.cognizant.model.Flight;
import com.cognizant.model.Passenger;

//@SpringBootTest
class FlightUnitTest {
	
	@Test
	void testAddEconomyFlight() {
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Economy");
		
		assertEquals("Economy", flight.getFlightType());
	}
	
	@Test
	void testAddBusinessFlight() {
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Business");
		
		assertEquals("Business", flight.getFlightType());
	}

	@Test
	void testVipPassengerToEconomyFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(true);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Economy");
		try {
			assertTrue(flight.addPassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
		
		try {
			assertFalse(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testVipPassengerToBusinessFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(true);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Business");
		
		try {
			assertTrue(flight.addPassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
		
		try {
			assertFalse(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testNonVipPassengerToEconomyFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(false);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Economy");
		
		try {
			assertTrue(flight.addPassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
		
		try {
			assertTrue(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testNonVipPassengerToBusinessFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(false);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Business");
		
		try {
			assertFalse(flight.addPassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
		
		try {
			assertTrue(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	void testRemoveVipPassengerFromEconomyFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(true);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Economy");
		try {
			assertFalse(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testRemoveVipPassengerFromBusinessFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(true);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Business");
		
		try {
			assertFalse(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testRemoveNonVipPassengerFromEconomyFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(false);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Economy");
		
		try {
			assertTrue(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testRemoveNonVipPassengerFromBusinessFlight() {
		Passenger passenger = new Passenger();
		passenger.setName("Raman");
		passenger.setVip(false);
		
		Flight flight = new Flight();
		flight.setId("FL001");
		flight.setFlightType("Business");
		try {
			assertTrue(flight.removePassenger(passenger));
		} catch (InvalidFlightOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
