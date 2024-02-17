package com.example.democrud;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.democrud.dao.AppDAO;
import com.example.democrud.entity.Course;
import com.example.democrud.entity.Instructor;
import com.example.democrud.entity.InstructorDetail;
import com.example.democrud.entity.Review;
import com.example.democrud.entity.Student;

@SpringBootApplication
public class DemocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocrudApplication.class, args);
	}
	
	// This method is annotated with @Bean so spring will inject InstructorDAO automatically and there is no need to write @Autowired
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		
		return runner -> {
			
//			createCourseAndStudents(appDAO);
			
//			retrieveCoursesAndStudents(appDAO);
			
//			retrieveStudentsAndCourses(appDAO);
			
//			addMoreCourseToStudents(appDAO);
			
//			addMoreStudentsToCourse(appDAO);
			
//			deleteCourse(appDAO);
			
			deleteStudent(appDAO);
			
		};
	}

	@SuppressWarnings("unused")
	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;
		
		System.out.println("Deleting Student Id: "+ theId);
		
		appDAO.deleteStudentById(theId);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void addMoreStudentsToCourse(AppDAO appDAO) {

		int theId = 1;
		
		Course course = appDAO.findCourseAndStudentsByCourseId(theId);
		
		//create Students
		Student theStudent1 = new Student("Divyansh", "Saxena", "divyansh@gmail.com");
		Student theStudent2 = new Student("Sahil", "Saxena", "sahil@gmail.com");
		
		//add courses to student
		course.addStudent(theStudent1);		
		course.addStudent(theStudent2);
		
		System.out.println("Updating Student: " + course);
		System.out.println("Associated Courses: "+ course.getStudents());
		
		appDAO.update(course);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void addMoreCourseToStudents(AppDAO appDAO) {

		int theId = 1;
		
		Student student = appDAO.findStudentAndCoursesByStudentsId(theId);
		
		//create more courses
		Course theCourse1 = new Course("Angular Course");
		Course theCourse2 = new Course("DSA - A Complete Guide");
		
		//add courses to student
		student.addCourse(theCourse1);		
		student.addCourse(theCourse2);
		
		System.out.println("Updating Student: " + student);
		System.out.println("Associated Courses: "+ student.getCourses());
		
		appDAO.update(student);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void retrieveStudentsAndCourses(AppDAO appDAO) {
		
		int theId = 1;
		System.out.println("Finding Course Id: " + theId);
		
		Student theStudent = appDAO.findStudentAndCoursesByStudentsId(theId);
		
		System.out.println("Student: "+ theStudent);
		
		System.out.println("Courses: "+ theStudent.getCourses());
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void retrieveCoursesAndStudents(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Finding Course Id: " + theId);
		
		Course theCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		
		System.out.println("Course: "+ theCourse);
		
		System.out.println("Students: "+ theCourse.getStudents());
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void createCourseAndStudents(AppDAO appDAO) {

		//create Courses
		Course theCourse1 = new Course("Spring Boot");
//		Course theCourse2 = new Course("DSA - A Complete Guide");
		
		//create Students
		Student theStudent1 = new Student("Divyansh", "Saxena", "divyansh@gmail.com");
		Student theStudent2 = new Student("Sahil", "Saxena", "sahil@gmail.com");
		
		//Add Students to Courses
		theCourse1.addStudent(theStudent1);		
		theCourse1.addStudent(theStudent2);
//		theCourse2.addStudent(theStudent2);
		
		//Save the Course and associated Students
		System.out.println("Saving the course: " + theCourse1);
		System.out.println("associated Students: "+ theCourse1.getStudents());
		appDAO.save(theCourse1);
//		appDAO.save(theCourse2);
		
		System.out.println("Done!");
		
	}

	@SuppressWarnings("unused")
	private void deleteCourseAndReview(AppDAO appDAO) {

		int theId = 1;
		
		System.out.println("Deleting Course Id: "+ theId);
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void retrieveCoursesAndReview(AppDAO appDAO) {

		// get course and reviews
		int theId = 1;
		System.out.println("Finding Course Id: " + theId);
		
		Course theCourse = appDAO.findCourseAndReviewByCourseId(theId);
		
		// print course
		System.out.println("Course: " + theCourse);
		
		// print reviews
		System.out.println("Reviews: " + theCourse.getReviews());
		
		List<Review> reviews = theCourse.getReviews();
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void createCourseAndReview(AppDAO appDAO) {

		// create Course
		Course theCourse = new Course("DSA - A Complete Guide");
		
		// add some reviews
		theCourse.addReview(new Review("Great Course... Loved It."));
		theCourse.addReview(new Review("Cool Course... Job done well"));
		theCourse.addReview(new Review("What a dumb course, you are an idiot"));
		
		// save the course... and leverage the cascadeAll
		System.out.println("Saving the Course...");
		appDAO.save(theCourse);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void deleteCourse(AppDAO appDAO) {
		
		int theId = 10;
		
		System.out.println("Finding Course id: " + theId);
		
		appDAO.deleteCourseById(theId);
		
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void updateCourse(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Finding Course Id" + theId);
		
		Course theCourse = appDAO.findCourseById(theId);
		
		theCourse.setTitle("Java Spring Boot");
		
		appDAO.update(theCourse);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding Instructor Id: "+ theId);
		
		Instructor theInstructor = appDAO.findInstructorById(theId);
		
		
		System.out.println("Updating Instructor Id: "+ theId);
		theInstructor.setLastName("Saxena");
		
		appDAO.update(theInstructor);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;
		
		System.out.println("Finding Instructor Id = " + theId);
		
		// This will retrieve instructor and courses because we added join fetch in our query(AppDAOImpl)
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associated Details: " +tempInstructor.getInstructorDetail());
		System.out.println("Associated Courses: " +tempInstructor.getCourses());
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		
		System.out.println("Finding Instructor Id = " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		// find Courses for instructor
		System.out.println("Finding Courses for Instructor Id: "+ theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		
		//associate the courses
		tempInstructor.setCourses(courses);
		
		System.out.println("associated courses: "+ tempInstructor.getCourses());
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		
		System.out.println("Finding Instructor Id = " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associated Courses: "+ tempInstructor.getCourses());
		
		System.out.println("Done!");		
	}

	@SuppressWarnings("unused")
	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor theInstructor = 
				new Instructor("Divyansh", "Saxena", "divyansh@hotmail.com");
		// create the instructordetsils
		InstructorDetail theInstructorDetail = 
				new InstructorDetail("https://www.youtube.com/@noobbnapiro5560", "Playing Games");
		
		// associate the objects
		theInstructor.setInstructorDetail(theInstructorDetail);
		
		//create some courses
		
		Course course1 = new Course("Air Guitar - The Ultimate Guitar");
		Course course2 = new Course("The pinball MasterClass");
		
		//add courses to istructor
		theInstructor.add(course1);
		theInstructor.add(course2);
		
		//save the instructor
		System.out.println("Saving Instructor: "+ theInstructor);
		System.out.println("The Courses are: "+ theInstructor.getCourses());
		appDAO.save(theInstructor);
		
		System.out.println("Done!");
	}

	@SuppressWarnings("unused")
	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 1;
		
		System.out.println("Deleting the InstructorDetail id: "+ theId);
		
		appDAO.deleteInstructorDetailById(theId);
		
		System.out.println("done");
	}

	@SuppressWarnings("unused")
	private void createInstructorDetail(AppDAO appDAO) {
		
		// create the instructordetsils
		InstructorDetail theInstructorDetail = 
				new InstructorDetail("https://www.youtube.com/@noobbnapiro5560", "Playing Games");
		
		// create the instructor
		Instructor theInstructor = 
				new Instructor("Divyansh", "Saxena", "divyansh@hotmail.com");
		
		// associate the objects
		theInstructorDetail.setInstructor(theInstructor);
		
		// This will also save the details object
		// because of CascadeType.ALL
		appDAO.save(theInstructorDetail);
		System.out.println("done");
	}

	@SuppressWarnings("unused")
	private void findInstructorDetail(AppDAO appDAO) {

		//get the instructorDetail object
		int theId = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		
		//print the instructor detail
		System.out.println("Instructor Detail =" + instructorDetail);
		
		//print associated Instructor
		System.out.println("Associated Instructor = " + instructorDetail.getInstructor());
		
		System.out.println("done");
	}

	@SuppressWarnings("unused")
	private void deleteInstructor(AppDAO appDAO) {
		
		int theId = 1;
		
		System.out.println("Deleting the Instructor id: "+ theId);
		
		appDAO.deleteInstructorById(theId);
		
		System.out.println("done");
	}

	@SuppressWarnings("unused")
	private void findById(AppDAO appDAO) {
		
		int theId = 1;
		
		System.out.println("Fnding instructor id: " + theId);
		Instructor theInstructor = appDAO.findInstructorById(theId);
		
		System.out.println(theInstructor);
		
	}

	@SuppressWarnings("unused")
	private void createInstructor(AppDAO appDAO) {
		
		// create the instructor
		Instructor theInstructor = 
				new Instructor("Divyansh", "Saxena", "divyansh@hotmail.com");
		// create the instructordetsils
		InstructorDetail theInstructorDetail = 
				new InstructorDetail("https://www.youtube.com/@noobbnapiro5560", "Playing Games");
		
		// create the instructor
		Instructor theInstructor2 = 
				new Instructor("Sahil", "Saxena", "sahil@hotmail.com");
		// create the instructordetsils
		InstructorDetail theInstructorDetail2 = 
					new InstructorDetail("https://www.youtube.com/@sahil1234", "Playing Football");
		
		// associate the objects
		theInstructor.setInstructorDetail(theInstructorDetail);

		// save the instructor
		System.out.println("Saving Instructor: " + theInstructor);
		
		// This will also save the details object
		// because of CascadeType.ALL
		appDAO.save(theInstructor);

		// associate the objects
		theInstructor2.setInstructorDetail(theInstructorDetail2);
		
		// save the instructor
		System.out.println("Saving Instructor: " + theInstructor2);
		
		// This will also save the details object
		// because of CascadeType.ALL
		appDAO.save(theInstructor2);
		System.out.println("done");
	}
}
