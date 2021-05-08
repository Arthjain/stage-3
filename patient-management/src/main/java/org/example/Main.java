package org.example;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	public static void main(String[] args) {
		log.info("Start");
		ClinicCalendar clinicCalendar = new ClinicCalendar();
		Scanner sc = new Scanner(System.in);
		
		String choice;

		while(true) {
			log.info("Patient Intake System");
			log.info("1. Add a patient appointment");
			log.info("2. View all appointments");
			log.info("3. Exit");

			choice = sc.next();

			switch (choice) {
			case "1": {
				addPatientAppointment(clinicCalendar);
				break;
			}
			case "2": {
				viewAllAppointment(clinicCalendar);
				break;
			}
			case "3": {
				log.info("End");
				break;
			}
			default: {
				log.info("Enter valid choice");
			}
			}
			if(choice.equals("3")) {
				break;
			}
		}
	}
	
	private static void addPatientAppointment(ClinicCalendar clinicCalendar) {
		Scanner sc = new Scanner(System.in);
		log.info("Enter Patient Name:");
		String name=sc.next();
		sc.nextLine();
		log.info("Enter your suitable appointment date & time dd-M-yyyy hh:MM a:");
		String appointmentDate=sc.nextLine();
		log.info("Select doctor:");
		log.info("PEDITRICIAN");
		log.info("CARDIOLOGIST");
		log.info("DENTIST");
		log.info("DERMATOLOGIST");
		log.info("ENTSPECIALST");
		String doctor = sc.next();
		clinicCalendar.addPatientAppointment(name, appointmentDate, doctor);
	}
	
	private static void viewAllAppointment(ClinicCalendar clinicCalendar) {
		log.info("Patients Appointment List");
		clinicCalendar.viewAllAppointment();
	}
}
