package com.cognizant.springlearn.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {

	@NotNull(message = "id should not be null")
    @Digits(fraction = 0, integer = 3)
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30, message = "Name should be atleast 2 characters and maximum 30 characters")
	private String name;

	@NotNull
	@Digits(fraction = 0, integer = 6, message = "salary should be zero or above")
	private int salary;

	@NotNull
	private boolean permanent;
	private Department department;
	private List<Skill> skills;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfBirth;

	public Employee() { }
	
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", department=" + department + ", skills=" + skills + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
