package com.example.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	//to show custom login page
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		
		
//		return "login-page";
		return "fancy-login";
	}
//	add a request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
//	add a request mapping for /systems
	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
	}
//	add a request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
