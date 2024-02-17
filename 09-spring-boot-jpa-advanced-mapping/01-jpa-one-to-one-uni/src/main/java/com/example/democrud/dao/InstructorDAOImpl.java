package com.example.democrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.democrud.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	private EntityManager entityManager;
	
	@Autowired
	public InstructorDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// this will save the Instructor details also as Cascade is CascadeType.All and due to OneToOne Mapping
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}
	
	// This will also retrieve instructorDetails object due to the default behaviour of @OneToOne 
	//fetch type is eager
	//Eager retrieves everything. Lazy retrieve on request
	@Override
	public Instructor findInstructorById(Integer id) {
		return entityManager.find(Instructor.class, id);
	}

	// this will delete the Instructor details also as Cascade is CascadeType.All and due to OneToOne Mapping
	@Override
	@Transactional
	public void deleteInstructorById(Integer theId) {
		
		if(theId != null) {
			//retrieve the instructor
			Instructor theInstructor = entityManager.find(Instructor.class, theId);
			
			//delete the instructor
			entityManager.remove(theInstructor);
		} else {
			System.out.println("Invalid Id");
		}
	}
}
