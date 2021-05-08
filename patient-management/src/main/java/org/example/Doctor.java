package org.example;

public enum Doctor {
	PEDITRICIAN("Dr. Raman, Peditrician"), CARDIOLOGIST("Dr. Aman, Cardiologist"), DENTIST("Dr. Ajay, Dentist"), 
	DERMATOLOGIST("Dr. Ray, Dermatologist"), ENTSPECIALST("Dr. Suman, ENT Specialist");

	private String name;
	
	Doctor(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

}
