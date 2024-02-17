package com.example.democrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.democrud.dao.InstructorDAO;
import com.example.democrud.entity.Instructor;
import com.example.democrud.entity.InstructorDetail;

@SpringBootApplication
public class DemocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocrudApplication.class, args);
	}
	
	// This method is annotated with @Bean so spring will inject InstructorDAO automatically and there is no need to write @Autowired
	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		
		return runner -> {
			
//			save(instructorDAO);
			
//			findById(instructorDAO);
			
			delete(instructorDAO);
		};
	}
	
	private void delete(InstructorDAO instructorDAO) {
		
		int theId = 1;
		
		System.out.println("Deleting the Instructor id: "+ theId);
		
		instructorDAO.deleteInstructorById(theId);
		
		System.out.println("done");
	}

	private void findById(InstructorDAO instructorDAO) {
		
		int theId = 1;
		
		System.out.println("Fnding instructor id: " + theId);
		Instructor theInstructor = instructorDAO.findInstructorById(theId);
		
		System.out.println(theInstructor);
		
	}

	private void save(InstructorDAO instructorDAO) {
		
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
		instructorDAO.save(theInstructor);

		// associate the objects
		theInstructor2.setInstructorDetail(theInstructorDetail2);
		
		// save the instructor
		System.out.println("Saving Instructor: " + theInstructor2);
		
		// This will also save the details object
		// because of CascadeType.ALL
		instructorDAO.save(theInstructor2);
		System.out.println("done");
	}

}
