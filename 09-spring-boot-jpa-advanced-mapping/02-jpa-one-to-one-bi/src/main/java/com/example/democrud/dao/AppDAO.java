package com.example.democrud.dao;

import com.example.democrud.entity.Instructor;
import com.example.democrud.entity.InstructorDetail;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(Integer id);
	
	void deleteInstructorById(Integer id);
	
	void save(InstructorDetail theInstructorDetail);
	
	InstructorDetail findInstructorDetailById(Integer id);
	
	void deleteInstructorDetailById(Integer id);

}
