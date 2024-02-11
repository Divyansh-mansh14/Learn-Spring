package com.example.springboot.thymeleafdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	// need a controller method to show initial HTML form.
	// When we use GetMapping ? is added to the URL followed by field1=value1 & field2=value2 amd so on
	// eg - http://localhost:8080/processFormVersionThree?studentName=Divyansh+Saxena
	
	// Whereas When we use PostMapping nothing is added to the URL 
	// eg - http://localhost:8080/processFormVersionThree as the data is sent in the HTTP message request body.
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	// need a controller method to process the HTML form.
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	
	//need a controller method to read form data add data to the model.
	// RequestMapping can work with any HTTP method. eg GET, POST, etc.
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		 
		//read the request parameter from the Html form.
		String name = request.getParameter("studentName");
		
		//covert the data to uppercase
		name = name.toUpperCase();
		
		// create the message.
		String result = "Yo! " + name;
		
		
		// add data to the model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}
	
	//Instead of using HttpServletRequest
	@RequestMapping("processFormVersionThree")
	// @Request Param is used to read HTML form data and automatically bind it to the parameter.
	public String letsShoutDudePFVT(@RequestParam("studentName") String theName, Model model) {
		
		//covert the data to uppercase
		theName = theName.toUpperCase();
		
		// create the message.
		String result = "Yo! " + theName;
		
		// add data to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
}
