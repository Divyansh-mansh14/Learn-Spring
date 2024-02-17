package com.example.democrud.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	// annotate the class and map it to database table
	
	// define the field annotate the fields with db column names
	
	// create constructor
	
	//generate getters/setters
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	// mappedBy refers to instructor details property in Instructor class
	@OneToOne(mappedBy="instructorDetail", cascade = CascadeType.ALL)
	private Instructor instructor;
	
	
	public InstructorDetail() {
		
	}
	
	public InstructorDetail(String youtubeChannel,  String hobby) {
		
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	
	public String getYoutubeChannel() {
		return this.youtubeChannel;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	

	public String getHobby() {
		return this.hobby;
	}
	
	public Instructor getInstructor() {
		return this.instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	@Override
	public String toString() {
		
		return "InstructorDetail{" +
				"id = " + this.id +
				", Youtube Channel = '"+ this.youtubeChannel + '\'' +
				", Hobby = '" + this.hobby +'\'' +
				"}";
	}
}
