package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	@Transactional
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		employeeDao.updateEmployee(employee);
	}
	
	@Transactional
	public List<Employee> deleteEmployee(int id) throws EmployeeNotFoundException {
		return employeeDao.deleteEmployee(id);
	}

}
