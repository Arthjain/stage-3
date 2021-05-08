package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundExeption;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	private static CountryService countryService;
	
	private static StockService stockService;
	
	private static EmployeeService employeeService;
	
	private static DepartmentService departmentService;
	
	private static SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		stockService = context.getBean(StockService.class);
		employeeService=context.getBean(EmployeeService.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		//Day 1
		//LOGGER.info("Inside main");
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		
		//Day 2
		testFindByNameContaining();
		testFindByNameStartingWith();
		testGetAllStocks();
		testFindByCodeAndDateBetween();
		testFindByCodeAndCloseGreaterThan();
		testFindTop3ByOrderByVolumeDesc();
		testFindTop3ByCodeOrderByVolume();
		testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();
		testGetAllPermanentEmployees();
		testGetAverageSalary();
		testGetAverageSalary();
		testGetAllEmployeesNative();
	}
	
	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	
	private static void getAllCountriesTest() {
		LOGGER.info("Start");
		Country country;
		try {
			country = countryService.findCountryByCode("AR");
			LOGGER.debug("Country={}", country);
		} catch (CountryNotFoundExeption e) {
			e.printStackTrace();
		}
		
		LOGGER.info("End");
	}
	
	private static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country();
		country.setCode("IN");
		country.setName("India");
		countryService.addCountry(country);
		try {
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country={}", country);
		} catch (CountryNotFoundExeption e) {
			e.printStackTrace();
		}
		
		LOGGER.info("End");
	}
	
	private static void testUpdateCountry() {
		LOGGER.info("Start");
		countryService.updateCountry("IN", "Indonesia");
		LOGGER.info("End");
	}
	
	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("IN");
		LOGGER.info("End");
	}
	
	private static void testFindByNameContaining() {
		LOGGER.info("Start");
		List<Country> countries = countryService.findByNameContainingOrderByName("ou");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	
	private static void testFindByNameStartingWith() {
		LOGGER.info("Start");
		List<Country> countries = countryService.findByNameStartingWith("Z");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	
	private static void testGetAllStocks() {
		LOGGER.info("Start");
		List<Stock> stocks = stockService.getAllStocks();
		LOGGER.debug("stocks={}", stocks);
		LOGGER.info("End");
	}
	
	private static void testFindByCodeAndDateBetween() {
		LOGGER.info("Start");
		try {
			Date start = new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2019");
			Date end=new SimpleDateFormat("dd/MM/yyyy").parse("31/09/2019");
			List<Stock> stocks = stockService.findByCodeAndDateBetween("FB", start, end);
			LOGGER.debug("stocks={}", stocks);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("End");
	}
	
	private static void testFindByCodeAndCloseGreaterThan() {
		LOGGER.info("Start");
		List<Stock> stocks = stockService.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal(1250));
		LOGGER.debug("stocks={}", stocks);
		LOGGER.info("End");
	}
	
	private static void testFindTop3ByOrderByVolumeDesc() {
		LOGGER.info("Start");
		List<Stock> stocks = stockService.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("stocks={}", stocks);
		LOGGER.info("End");
	}
	
	private static void testFindTop3ByCodeOrderByVolume() {
		LOGGER.info("Start");
		List<Stock> stocks = stockService.findTop3ByCodeOrderByVolume("NFLX");
		LOGGER.debug("stocks={}", stocks);
		LOGGER.info("End");
	}
	
	private static void testGetEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");

	}
	
	private static void testAddEmployee() {
		LOGGER.info("Start");
		Employee employee = new Employee();
		employee.setId(5);
		employee.setName("Harry");
		employee.setSalary(new BigDecimal(15000.00));
		employee.setPermanent(false);
		try {
			employee.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("01/03/1997"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Department department=departmentService.get(1);
		employee.setDepartment(department);
		
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}
	
	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(3);
		Department department=departmentService.get(2);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}
	
	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department=departmentService.get(2);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Employees:{}", department.getEmployeeList());
		LOGGER.info("End");
	}
	
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee=employeeService.get(3);
		Skill skill=skillService.get(2);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}
	
	private static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees=employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e->LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	
	/*private static void testGetAverageSalary() {
		LOGGER.info("Start");
		double avgSal=employeeService.getAverageSalary();
		LOGGER.debug("Average Salary:{}", avgSal);
		LOGGER.info("End");
	}*/
	
	private static void testGetAverageSalary() {
		LOGGER.info("Start");
		double avgSal=employeeService.getAverageSalary(1);
		LOGGER.debug("Average Salary:{}", avgSal);
		LOGGER.info("End");
	}
	
	private static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employees=employeeService.getAllEmployeesNative();
		LOGGER.debug("Employees:{}", employees);
		LOGGER.info("End");
	}

}
