package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	public List<Employee> getAllPermanentEmployees();
	
	/*@Query("SELECT AVG(e.salary) FROM Employee e")
	public double getAverageSalary();*/
	
	@Query("SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
	public double getAverageSalary(@Param("id") int id);
	
	@Query(value="SELECT * FROM employee", nativeQuery = true)
	public List<Employee> getAllEmployeesNative();

}
