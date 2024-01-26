package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	
	Student findById(int id);
	
	List<Student> findByLastName(String theLastName);
	
	List<Student> findAll();
	
	List<Student> findUsingOrPredicate(String name);
	
	List<Student> findUsingLikePredicate();
	
	List<Student> findUsingOrderByPredicate();
	
	void update(Student theStudent);
	
	int updateAll();
	
	void removeStudent(int id);
	
	int removeAll();
}
