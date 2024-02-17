package com.example.democrud.dao;

import com.example.democrud.entity.Instructor;

public interface InstructorDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(Integer id);
	
	void deleteInstructorById(Integer id);

}
