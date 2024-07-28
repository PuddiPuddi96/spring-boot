package it.davide.course.employeeaop.service;

import java.util.List;

import it.davide.course.employeeaop.entity.Employee;

public interface EmployeeService {

	void save(Employee theEmployee);
	Employee findById(int theId);
	List<Employee> findAll();
	void deleteById(int theId);
	
}
