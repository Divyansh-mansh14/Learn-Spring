package com.example.springboot.thymeleafdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	// Create Mapping for "/hello".
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		// this name should be same as the name of the thymeleaf template(.html) file in the src/main/resources/template
		return "helloworld2";
	}
	
	@GetMapping("/error")
	public String errorFound() {
		System.out.println("Error");
		return "Error";
	}
}
