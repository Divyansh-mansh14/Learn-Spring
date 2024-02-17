package com.example.democrud.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade={CascadeType.DETACH, CascadeType.PERSIST,
					 CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students;

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
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	// add a convenience method
	public void addReview(Review theReview) {
		
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(theReview);
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	// add a convenience method
	
	public  void addStudent(Student theStudent) {
		if(students == null) {
			students = new ArrayList<>();
		}
		
		students.add(theStudent);
	}

	@Override
	public String toString() {
		return " Course {" +
				"id="+ id +
				", title='" + title +'\'' +
				"}";
	}
}
