package com.cognizant.springlearn.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {

	@NotNull
	@Digits(fraction = 0, integer = 2)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min=1, max=30, message="name should be minimum 1 character and maximum 30 characters")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
