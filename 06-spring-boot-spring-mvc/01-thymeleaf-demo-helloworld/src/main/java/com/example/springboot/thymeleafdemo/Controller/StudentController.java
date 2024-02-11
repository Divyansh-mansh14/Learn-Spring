package com.example.springboot.thymeleafdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {
	
	// here we are binding the value of countries which are defined in the application.properties file.
	@Value("${countries}")
	private List<String> countries;
	
	// here we are binding the value of Languages which are defined in the application.properties file.
	@Value("${languages}")
	private List<String> languages;
	
	// here we are binding the value of Languages which are defined in the application.properties file.
	@Value("${operatingSystems}")
	private List<String> operatingSystem;

	@GetMapping("/showStudentForm") 
	public String showForm(Model theModel) {
		
		// create Student object
		Student theStudent = new Student();
		
		// Add Student Object to the model
		theModel.addAttribute("student", theStudent);
		
		// Add the List of countries to the model
		theModel.addAttribute("countries", countries);
		
		// Add the List of languages to the model
		theModel.addAttribute("languages", languages);
		
		// Add the List of OS to the model
		theModel.addAttribute("operatingSystem", operatingSystem);
		
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	//@ModelAttribute will bind the model attribbute(student) to the parameter(theStudent) 
	//that we have passed in.
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input data onto the console.
		System.out.println("theStudent: " + theStudent.getFirstName()+ " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}
