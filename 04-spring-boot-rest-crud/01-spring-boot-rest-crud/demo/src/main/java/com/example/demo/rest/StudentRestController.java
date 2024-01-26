package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define a post construct to load the student data... it is called only once after bean is loaded.
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Divyansh", "Saxena"));
		theStudents.add(new Student("Sahil", "Saxena"));
		theStudents.add(new Student("Shivam", "Saxena"));
	}

	//define endpoint for "/student" - return a list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	//define endpoint for "/students/{studentId}" - return student at a given index
	//studentId is the path variable
	@GetMapping("/students/{studentId}")
	// The path variable and the method parameter should match or should be same
	//In this case they are "studentId"
	public Student getStudent(@PathVariable int studentId) {
		
		//check the studentId against list size.
		if(studentId < 0 || studentId > theStudents.size()) {
			throw new StudentNotFoundException("student id not found: " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	
	//Removing the Exception handlerMethods as we are using global exception Handler using @Controller Advice in class StudentException Handler.
	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//		
//		//create a student error response.
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		//return Response Entity
//		
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
	
//	//adding this Exception handler method incase if someone enter a non integer value in place of studentId
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		//we can write custom message also by
////		error.setMessage("Wrong Choice");
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		//return response entity
//		
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
}
