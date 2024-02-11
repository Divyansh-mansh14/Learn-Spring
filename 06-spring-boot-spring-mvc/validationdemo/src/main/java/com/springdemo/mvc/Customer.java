package com.springdemo.mvc;

import com.springdemo.mvc.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	@Pattern(regexp="^[a-zA-z0-9]{6}", message="Only 5 Chars/Digits")
	private String postalCode;
	
	@CourseCode(value="ABC", message="must start with ABC")
	private String courseCode;
	
	@NotNull(message="is required")
	@Min(value=0, message="value must be greater than or equal to 0")
	@Max(value=10, message="value must be less than or equal to 10")
	//we are making the return type to Integer as if nothing is entered it will convert that to nullut in case of int an error will be 
	//shown:- Failed to convert property value of type java.lang.String to required type int for property freePasses; For input string: "" 
	private Integer freePasses;

	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getFreePasses() {
		return this.freePasses;
	}
	
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public void setCourseCode(String theCode) {
		this.courseCode = theCode;
	}
}
