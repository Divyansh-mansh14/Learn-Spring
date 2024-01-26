package com.example.cruddemo.service;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee theemployee);
	
	void deleteById(int theId);
}
