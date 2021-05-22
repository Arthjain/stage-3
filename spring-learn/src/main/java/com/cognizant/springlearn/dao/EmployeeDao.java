package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Component
public class EmployeeDao {
	
	private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	
	@SuppressWarnings("unchecked")
	public EmployeeDao() {
		try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("employee.xml")) {
			EMPLOYEE_LIST = (List<Employee>) classPathXmlApplicationContext.getBean("employeeList");
		}
	}
	
	public List<Employee> getAllEmployees() {
		return EmployeeDao.EMPLOYEE_LIST;
	}
	
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		boolean isEmployeeFound = false;
		
		for(Employee emp : EMPLOYEE_LIST) {
			if(emp.getId() == employee.getId()) {
				isEmployeeFound = true;
				
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setPermanent(employee.isPermanent());
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setDepartment(employee.getDepartment());
				emp.setSkills(employee.getSkills());
				
				LOGGER.info("Employee updated ", employee);
			}
		}
		
		if(!isEmployeeFound) 
			throw new EmployeeNotFoundException(); 
	}
	
	public List<Employee> deleteEmployee(int id) throws EmployeeNotFoundException {
		Iterator<Employee> itr = EMPLOYEE_LIST.iterator();
		while(itr.hasNext()) {
			Employee emp = itr.next();
			
			if(emp.getId() == id) {
				itr.remove();
				
				return EMPLOYEE_LIST;
			}
		}
		
		throw new EmployeeNotFoundException();
	}

}
