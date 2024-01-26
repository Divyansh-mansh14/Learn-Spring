package com.example.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.cruddemo.entity.Employee;

//it will change the endpoint to /members from /employees
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//that's it... no need to write any code here.

}
