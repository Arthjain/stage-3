package org.example;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatientAppointment {
	
	private String name;
	private Date appointmentDate;
	private Doctor doctor;
	
	@Override
	public String toString() {
		return "PatientAppointment [name=" + name + ", appointmentDate=" + appointmentDate + ", doctor=" + doctor.getName() + "]";
	}
	
	

}
