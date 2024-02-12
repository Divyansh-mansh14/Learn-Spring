package com.luv2code.springboot.thymeleafcruddemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafcruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
    
    List<Employee> findAllByOrderByLastNameAsc();

}
