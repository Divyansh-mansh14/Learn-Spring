package com.example.democrud.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	// annotate the class and map it to database table
	
	// define the field annotate the fields with db column names
	
	//** set up mapping to Instructor entity
	
	// create constructor
	
	//generate getters/setters
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	
	public Course() {
		
	}
	
	public Course(String theTitle) {
		title = theTitle;
	}
	
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST, 
						CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	public void setId(int theId) {
		id = theId;
	}

	public int getId() {
		return this.id;
	}
	
	public void setInstructor(Instructor theInstructor) {
		instructor = theInstructor;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}
	
	public void setTitle(String theTitle) {
		title = theTitle;
	}

	public String getTitle() {
		return this.title;		
	}
	
	@Override
	public String toString() {
		return " Course {" +
				"id="+ id +
				", title='" + title +'\'' +
				"}";
	}
}
