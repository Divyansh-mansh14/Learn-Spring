package com.example.democrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.democrud.entity.Course;
import com.example.democrud.entity.Instructor;
import com.example.democrud.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		
		//retrieve the instructor
		Instructor theInstructor = entityManager.find(Instructor.class, theId);
		
		//get the courses
		List<Course> courses = theInstructor.getCourses();
		
		//we have to break the association of all the courses for the instructor 
		//because if we will not do that org.hibernate will show an error 
		//SQLCostraintIntegrityVoilationException / ConstraintViolationException / DataIntegrityViolationException
		//break the association of all the courses for the instructor
		for(Course tempCourse : courses) {
			tempCourse.setInstructor(null);
		}
		
		//delete the instructor
		entityManager.remove(theInstructor);
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

	@Override
	public List<Course> findCoursesByInstructorId(Integer theId) {

		TypedQuery<Course> query = entityManager.createQuery
						   ("from Course where instructor.id =:data", Course.class);
		
		query.setParameter("data", theId);
		
		//execute query
		List<Course> courses = query.getResultList();
		
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(Integer theId) {

		//Even with instructor @OneToMany - FetchType.LAZY
		//TheCode will Still retrieve instructor and courses
		//JOIN FETCH is similar to EAGER loading.
		//Here i is an alias name for instructor
		//create query
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+
																 "JOIN FETCH i.courses " +
																 "JOIN FETCH i.instructorDetail " +
																 "where i.id = :data", Instructor.class);
		query.setParameter("data", theId);
		
		Instructor instructor = query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor theInstructor) {

		entityManager.merge(theInstructor);
	}

	@Override
	public Course findCourseById(Integer theId) {

		return entityManager.find(Course.class, theId);
	}
	
	@Override
	@Transactional
	public void update(Course theCourse) {

		entityManager.merge(theCourse);

	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {

		Course tempCourse = entityManager.find(Course.class, theId);
		
		entityManager.remove(tempCourse);
	}
}
