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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	// annotate the class and map it to database table
	
	// define the field annotate the fields with db column names
	
	//** set up mapping to Course entity
	
	// create constructor
	
	//generate getters/setters
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy="instructor",
			fetch=FetchType.LAZY,
			cascade={CascadeType.DETACH, CascadeType.PERSIST,
					 CascadeType.MERGE, CascadeType.REFRESH})
	private List<Course> courses;
	
	public Instructor() {
		
	}
	
	public Instructor(String firstName,  String lastName, String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public InstructorDetail getInstructorDetail() {
		return this.instructorDetail;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public List<Course> getCourses() {
		return this.courses;
	}
	
	// add convenience method for bi directional relationship
	public void add(Course tempCourse) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempCourse);
		
		tempCourse.setInstructor(this);
	}
	
	@Override
	public String toString() {
		
		return "Instructor{" +
				"id = " + this.id +
				", First Name = '"+ this.firstName + '\'' +
				", Last Name = '"+ this.lastName + '\'' +
				", Email = '" + this.email +'\'' +
				"}";
	}
}
