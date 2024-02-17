package com.example.democrud.dao;

import java.util.List;

import com.example.democrud.entity.Course;
import com.example.democrud.entity.Instructor;
import com.example.democrud.entity.InstructorDetail;
import com.example.democrud.entity.Student;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(Integer id);
	
	void deleteInstructorById(Integer id);
	
	void save(InstructorDetail theInstructorDetail);
	
	InstructorDetail findInstructorDetailById(Integer id);
	
	void deleteInstructorDetailById(Integer id);
	
	List<Course> findCoursesByInstructorId(Integer theId);
	
	Instructor findInstructorByIdJoinFetch(Integer theId);
	
	void update(Instructor theInstructor);
	
	void update(Course theCourse);

	Course findCourseById(Integer theId);
	
	void deleteCourseById(int theId);
	
	void save(Course theCourse);
	
	Course findCourseAndReviewByCourseId(Integer theId);
	
	Course findCourseAndStudentsByCourseId(Integer theId);
	
	Student findStudentAndCoursesByStudentsId(Integer theId);
	
	void update(Student theStudent);
	
	void deleteStudentById(Integer theId);
}
