package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//create Query
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
		
		//get the List of Students
		List<Employee> employees = theQuery.getResultList();
		
		//return list
		return employees;
	}
	
	@Override
	public Employee findById(int id) {
		
		//get employee
		Employee employee = entityManager.find(Employee.class, id);
		
		//return employee
		return employee;
	}
	
	
	//We are not using @Transactional here as we will handle or use @Transactional at the Service layer.
	@Override
	public Employee save(Employee theEmployee) {
		//entityManager.merge(theEmployee) works based on the id 
		//if id = 0 then it will insert a new employee 
		//else it will update the existing employee.
		
		//entityManager.merge(theEmployee) will simply: 
		// (1) add a new employee if it doesn't exist
		// (2) else it will update the existing employee.
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//return the employee
		return dbEmployee;
	}


	@Override
	public void deleteById(int theId) {
		//retrieve the employee to be deleted.
		Employee theEmployee = entityManager.find(Employee.class, theId);
		// Another way of retrieving.
		//Employee theEmployee = findById(theId);
		
		//delete the employee
		entityManager.remove(theEmployee);		
	}
}
