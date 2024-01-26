package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExeptionHandler {

	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		//create a student error response.
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return Response Entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
		//adding this Exception handler method incase if someone enter a non integer value in place of studentId
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			//we can write custom message also by
			//error.setMessage("Wrong Choice");
			error.setTimeStamp(System.currentTimeMillis());
			
			//return response entity
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
}
