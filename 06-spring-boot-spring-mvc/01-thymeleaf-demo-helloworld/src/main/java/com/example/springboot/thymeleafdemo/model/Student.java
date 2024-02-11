package com.example.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private List<String> favouriteOperatingSystem;
	
	public Student() {
		
	}
	
	public Student(String theFirstName, String theLastName, String theCountry, String theLanguage) {
		firstName = theFirstName;
		lastName = theLastName;
		country = theCountry;
		favouriteLanguage = theLanguage;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String theFirstName) {
		firstName = theFirstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String theLastName) {
		this.lastName = theLastName;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String theCountry) {
		this.country = theCountry;
	}
	
	public String getFavouriteLanguage() {
		return this.favouriteLanguage;
	}
	
	public void setFavouriteLanguage(String theLanguage) {
		this.favouriteLanguage = theLanguage;
	}
	
	public List<String> getFavouriteOperatingSystem() {
		return this.favouriteOperatingSystem;
	}
	
	public void setFavouriteOperatingSystem(List<String> favouriteOperatingSystem) {
		this.favouriteOperatingSystem = favouriteOperatingSystem;
	}
}
