package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	//define field for entity manager.
	private EntityManager entityManager;
	
	
	//Inject Entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	
	//Implement save method
	@Override
	//Adding @Transactional since we are performing an update.
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	// We won't add @Transactional here as no update is being made in the database
	//and we are simply doing a query.
	@Override
	public Student findById(int id) {
		// If id is not found it will return null
		return entityManager.find(Student.class, id);
	}
	
	@Override
	public List<Student> findByLastName(String theLastName) {
		//In the Query we use Entity class and field names rather than table and column names.
		//theData is the named parameter. JPQL named parameters are prefixed with a colon.
		//It is like a place holder which we can fill in later.
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =:theData", Student.class);
		//here we are giving the value lastName to theData(JPQL Named Parameter)
		theQuery.setParameter("theData", theLastName);
		return theQuery.getResultList();
	}
	
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		return theQuery.getResultList();
	}
	
	@Override
	public List<Student> findUsingOrPredicate(String name) {
		//We can either use theData or we can simply write what we want to search for.
		TypedQuery<Student> theQuery = entityManager.createQuery
				("FROM Student WHERE firstName=:theData"
				+ " OR lastName=:theData ", Student.class);
		
		theQuery.setParameter("theData", name);
		
		return theQuery.getResultList();
	}
	
	@Override
	public List<Student> findUsingLikePredicate() {
		TypedQuery<Student> theQuery = entityManager.createQuery
				("FROM Student WHERE email LIKE '%@gmail.com' ", Student.class);
		//TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName LIKE '%nsh' ", Student.class);
		//TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName LIKE '%ivy%' ", Student.class);
		//TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName LIKE 'Divy%' ", Student.class);
		
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findUsingOrderByPredicate() {
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName desc", Student.class);
		
		// By default it is arranged in ascending order.
		//TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName", Student.class);
		return theQuery.getResultList();
	}
	
	@Override
	@Transactional
	public void update(Student theStudent) {
		
		entityManager.merge(theStudent);
	}
	
	@Override
	@Transactional
	public int updateAll() {
		// while updating all we don't have to give the class name as parameter.
		int numRowsUpdated = entityManager.createQuery("UPDATE Student SET lastName='Saxena'").executeUpdate();
		return numRowsUpdated;
	}
	
	@Override
	@Transactional
	public void removeStudent(int id) {
		Student theStudent = findById(id);
		entityManager.remove(theStudent);
	}
	
	@Override
	@Transactional
	public int removeAll() {
		// while deleting all we don't have to give the class name as parameter.
		int numRowsDeleted = entityManager.createQuery
				("DELETE FROM Student").executeUpdate();
		
		return numRowsDeleted;
	}
}
