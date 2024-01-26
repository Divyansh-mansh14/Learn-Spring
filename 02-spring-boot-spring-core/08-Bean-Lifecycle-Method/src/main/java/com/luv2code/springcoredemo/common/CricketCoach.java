package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)//No need to Specify Singleton. By default it is singleton.
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In Constuctor: "+ getClass().getSimpleName());
	}
	
	//define our init(initialization) method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff(): "+ getClass().getSimpleName());
	}
	
	
	//define our Destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In doMyCleanupStuff(): "+ getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	} 
}
