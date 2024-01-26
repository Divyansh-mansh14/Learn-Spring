package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	// CommandLineRunner is from the spring boot Framework.
	// It will execute after the beans are loaded.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		// the is a Java Lambda Expression 
		// shortcut implementation for providing implementation of command line runner interface
		// It will execute after the spring beans have been loaded.
		return runner -> {
//			createStudent(studentDAO);
			
//			ceateMultipleStudent(studentDAO);
			
//			readStudent(studentDAO);
			
//			queryForStudents(studentDAO);
			
//			queryForStudentsByLastName(studentDAO);
			
//			queryUsingLikePredicate(studentDAO);
			
//			queryUsingOrPredicate(studentDAO);
			
//			queryUsingOrderByPredicate(studentDAO);
			
//			updateStudent(studentDAO);
			
//			deleteStudent(studentDAO);
			
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		
		System.out.println("Deleting All Students");
		int numRowsDeleted = studentDAO.removeAll();
		System.out.println("Deleted Rows Count: " +  numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//retrieve Student based on the id: Primary Key
		int studentId = 5;
		System.out.println("Getting Student based on id: " + studentId);
		
//		Student student = studentDAO.findById(studentId);
		
		//removing student
		studentDAO.removeStudent(studentId);
		
		//get the List of all remaining student
		List<Student> students = studentDAO.findAll();
		
		//Display the remaining students List.
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		
		//retrieve Student based on id: Primary Key
		int studentId = 6;
		System.out.println("Getting Student based on id: "+ studentId);
		
		Student myStudent = studentDAO.findById(studentId);
		
		System.out.println("Updating Student...");
		
		//Changing firstName and email.
		myStudent.setFirstName("Honey");
		myStudent.setEmail("honey@gmail.com");
		studentDAO.update(myStudent);
		
		//Display Updated Student
		System.out.println("Updated Student: " + myStudent);
	}

	private void queryUsingOrderByPredicate(StudentDAO studentDAO) {
		
		//get the List of all students
		List<Student> theStudents = studentDAO.findUsingOrderByPredicate();
		
		//print the List of all Students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryUsingOrPredicate(StudentDAO studentDAO) {
		
		//get the List of all Students.
		List<Student> students = studentDAO.findUsingLikePredicate();
		
		//Print the list of all Students.
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
		
	}

	private void queryUsingLikePredicate(StudentDAO studentDAO) {
		
		//get the List of all Students.
		List<Student> students = studentDAO.findUsingOrPredicate("Divyansh");
		
		//Print the list of all Students.
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get the List of all Students
		List<Student> students = studentDAO.findAll();
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
		
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		
		//get List of all Students
		List<Student> students = studentDAO.findByLastName("Saxena");
		
		//print List of all Students
		for(Student tempStudent : students) {
			System.out.println(tempStudent);			
		}
	}
	
	private void readStudent(StudentDAO studentDAO) {
		
		//Create the Student Object
		System.out.println("Creating the Student Object");
		Student theStudent = new Student("Shivam", "Saxena", "Shivam@gmail.com");
		
		//Saving the Student Object
		System.out.println("Saving the Student...");
		studentDAO.save(theStudent);
		
		//display id of the saved Student
		int theId = theStudent.getId();
		System.out.println("Student Saved. Id = " + theId);
		
		//Retrieve Student based on the id: Primary key
		System.out.println("Retrieving student with id: " +theId);
		Student myStudent = studentDAO.findById(theId);
		
		//Reading the Student
		System.out.println("Found the Student: "+ myStudent);
		
	}

	private void ceateMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 4 Students");
		Student student1 = new Student("Divyansh", "Saxena", "divyansh@gmail.com");
		Student student2 = new Student("Sahil", "Saxena", "sahil@gmail.com");
		Student student3 = new Student("Umang", "Saxena", "umang@gmail.com");
		Student student4 = new Student("Mayank", "Saxena", "Mayank@gmail.com");
		
		System.out.println("Saving 4 Students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
		
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the Student Object
		System.out.println("Creating the Student Object");
		Student theStudent = new Student("Divyansh", "Saxena", "divyansh@gmail.com");
		
		//Saving the Student Object
		System.out.println("Saving the Student");
		studentDAO.save(theStudent);
		
		//display id of the saved Student
		System.out.println("Student Saved. Id = " + theStudent.getId());
	}

}
