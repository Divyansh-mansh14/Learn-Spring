package com.example.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;

//import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		//Different Pattern instead of having to check for result. Feature introduced in Java 8.
		//A variable whose type is Optional should never itself be null;
		//it should always point to an Optional instance.
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			//If a value is present, returns the value, otherwise throws NoSuchElementException.
			theEmployee = result.get();
		}
		else {
			//we didn't find the Employee.
			throw new RuntimeException("Didn't find the Employee Id - " + id);
		}
		
		return theEmployee;
	}

	//we don't need @Transactional here as spring data Jpa will take care of it.
	//JpaRepository Provides this(@Transactional) functionality.
	@Override
//	@Transactional
	public Employee save(Employee theemployee) {
		Employee employee = employeeRepository.save(theemployee);
		return employee;
	}

	@Override
//	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	
	
}
