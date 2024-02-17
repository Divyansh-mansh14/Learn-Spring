package com.example.democrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.democrud.dao.AppDAO;
import com.example.democrud.entity.Instructor;
import com.example.democrud.entity.InstructorDetail;

@SpringBootApplication
public class DemocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocrudApplication.class, args);
	}
	
	// This method is annotated with @Bean so spring will inject InstructorDAO automatically and there is no need to write @Autowired
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		
		return runner -> {
			
//			createInstructor(appDAO);
			
//			findById(appDAO);
			
//			delete(appDAO);
			
//			findInstructorDetail(appDAO);
			
//			createInstructorDetail(appDAO);
			
//			deleteInstructorDetail(appDAO);
		};
	}
	
	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 2;
		
		System.out.println("Deleting the InstructorDetail id: "+ theId);
		
		appDAO.deleteInstructorDetailById(theId);
		
		System.out.println("done");
	}

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

	private void delete(AppDAO appDAO) {
		
		int theId = 1;
		
		System.out.println("Deleting the Instructor id: "+ theId);
		
		appDAO.deleteInstructorById(theId);
		
		System.out.println("done");
	}

	private void findById(AppDAO appDAO) {
		
		int theId = 1;
		
		System.out.println("Fnding instructor id: " + theId);
		Instructor theInstructor = appDAO.findInstructorById(theId);
		
		System.out.println(theInstructor);
		
	}

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
