package com.luv2code.springboot.thymeleafcruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafcruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code 
	
	// Spring dataJpa will parse the method name and will look for a specific format or pattern 
	// and will create appropriate query behind the scenes
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	//findAllBy is part of the pattern and OrderByLastNameAsc spring will parse that by OrderBy clause 
	//spring data jpa will run the query "from employee order by lastName asc" behind the scene automatically
}
