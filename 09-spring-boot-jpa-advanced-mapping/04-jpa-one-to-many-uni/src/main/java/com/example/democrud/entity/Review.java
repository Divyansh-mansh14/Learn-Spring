package com.example.democrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	// annotate the class and map it to database table
	
	// define the field annotate the fields with db column names
	
	//** set up mapping to Instructor entity
	
	// create constructor
	
	//generate getters/setters
	
	// generate toString() method
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="comment")
	private String comment;

	public Review() {
		
	}
	
	public Review(String comment) {
		this.comment = comment;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
}
