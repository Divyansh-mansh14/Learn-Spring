package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee theemployee);
	
	void deleteById(int theId);
}
