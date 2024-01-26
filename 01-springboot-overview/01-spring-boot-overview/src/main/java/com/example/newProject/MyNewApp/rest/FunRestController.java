package com.example.newProject.MyNewApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// Inject properties for: coach.name and team.name.
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/properties")
	public String getValues() {
		return "Coach Name: "+ coachName + ", Team Name: " + teamName;
	}
	
	
	//expose "/" that return Hello World
	@GetMapping("/")
	public String sayHello() {
		return("Hello World");
	}
	
	//expose a new endpoint for workout.
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return("Go do some Workout");
	}
	
	//expose a new endpoint for fortune.
	@GetMapping("/fortune")
	public String getMyFortube() {
		return("You will have a Lucky Day");
	}
	
}
