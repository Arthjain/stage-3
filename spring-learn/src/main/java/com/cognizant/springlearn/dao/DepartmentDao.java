package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Department;

@Component
public class DepartmentDao {

	private static List<Department> DEPARTMENT_LIST = new ArrayList<Department>();
	
	DepartmentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList");
	}
	
	public List<Department> getAllDepartments() {
		return this.DEPARTMENT_LIST;
	}

}
