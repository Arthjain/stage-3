package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ClinicCalendar {
	
	private List<PatientAppointment> appointmentsList=new ArrayList<>();
	
	public boolean addPatientAppointment(String name, String appointmentDate, String doctor) {
		log.info("Start");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm a");
		Date date;
		try {
			date = dateFormat.parse(appointmentDate);
		} catch (ParseException e) {
			log.error("Wrong fromat !!! Enter date in dd-M-yyyy hh:mm a");
			log.info("End");
			return false;
		}
		
		Doctor doc = Doctor.valueOf(doctor.toUpperCase());
		PatientAppointment patientAppointment = new PatientAppointment(name, date, doc);
		appointmentsList.add(patientAppointment);
		log.info("Appointment Created Successfully");
		log.info("End");
		return true;
	}
	
	public void viewAllAppointment() {
		log.info("Start");
		if(appointmentsList.isEmpty()) {
			log.info("There are no appointments till now!!");
		}
		else {
			log.debug("Appointment List: {}", appointmentsList);
		}
		log.info("End");
	}
}
