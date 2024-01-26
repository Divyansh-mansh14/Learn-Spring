package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	private Coach myCoach;
	private Coach anotherCoach;

	@Autowired
	public DemoController(
			@Qualifier("cricketCoach")Coach myCoach, 
			@Qualifier("cricketCoach")Coach anotherCoach) {
		System.out.println("In Constuctor: "+ getClass().getSimpleName());
		this.myCoach = myCoach;
		this.anotherCoach = anotherCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/check")
	public String check() {
		return "Another Coach == myCoach: " + (anotherCoach == myCoach);//return true when SCOPE_PROTOTYPE is not used.
	}
}