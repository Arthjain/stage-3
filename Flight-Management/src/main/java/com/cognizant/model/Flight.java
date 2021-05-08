package com.cognizant.model;


import java.util.ArrayList;
import java.util.List;

import com.cognizant.exception.InvalidFlightOperationException;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Flight {
	private String id;
	private String flightType;
	private List<Passenger> passengers=new ArrayList<>();
	private static final String MESSAGE="Cannot Add Passenger due to Invalid Constraints";
	
	public boolean addPassenger(Passenger passenger) throws InvalidFlightOperationException {
		log.info("Start");
		if(flightType.equalsIgnoreCase("economy")) {
			passengers.add(passenger);
			log.info("End");
			return true;
		}
		else {
			if(passenger.isVip()) {
				passengers.add(passenger);
				log.info("End");
				return true;
			}
			else {
				log.error(MESSAGE);
				throw new InvalidFlightOperationException(MESSAGE);
			}
		}
	}
	
	public boolean removePassenger(Passenger passenger) throws InvalidFlightOperationException {
		log.info("Start");
		if(passenger.isVip()) {
			log.error(MESSAGE);
			throw new InvalidFlightOperationException(MESSAGE);
		}
		else {
			passengers.remove(passenger);
			log.info("End");
			return true;
		}
	}
}
