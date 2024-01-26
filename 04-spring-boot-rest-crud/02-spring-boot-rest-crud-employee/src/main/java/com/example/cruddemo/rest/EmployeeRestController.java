package com.example.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee not Found by id: " + employeeId);
		}
		
		return theEmployee;
	}
	
	//When a client sends a POST request to the /login employees with a JSON or XML document in the body, 
	//the Spring Framework will automatically deserialize the document into a Employee object 
	//and pass it to the addEmployee() method.
	@PostMapping("/employees")
	//we are using @RequestBody as employee data will be sent as json in Request Body.
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//also just incase if they pass an id in JSON... set id to 0.
		//this is to force a save of new item instead of update.
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/employees")
	//we are using @RequestBody as employee data will be sent as json in Request Body
	public Employee update(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found: " + employeeId);
		}
		employeeService.deleteById(employeeId);
		
		return "Deleted Employee id: " +employeeId;
	}
}
	
	
