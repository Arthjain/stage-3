package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class PatientIntakeSystemApplicationTests {
	
	@Test
	void testAddNewAppointment() {
		ClinicCalendar clinicCalendar = new ClinicCalendar();
		
		clinicCalendar.addPatientAppointment("Sumit", "02-08-2020 09:40 am", "Peditrician");
		
		assertEquals(1, clinicCalendar.getAppointmentsList().size());
	}

	@Test
	void testAddPatientAppointment() {
		ClinicCalendar clinicCalendar = new ClinicCalendar();
		
		assertTrue(clinicCalendar.addPatientAppointment("Sumit", "02-08-2020 09:40 am", "Peditrician"));
		
		assertFalse(clinicCalendar.addPatientAppointment("Shreyas", "02/08/2020", "Dentist"));
	}

}
