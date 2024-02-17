package com.example.democrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.democrud.entity.Instructor;
import com.example.democrud.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl (EntityManager entityManager) {
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

	@Override
	@Transactional
	public void save(InstructorDetail theInstructorDetail) {
		
		entityManager.persist(theInstructorDetail);
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(Integer theId) {

		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
		
		return instructorDetail;
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(Integer theId) {

		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
		
		entityManager.remove(instructorDetail);
	}
}
