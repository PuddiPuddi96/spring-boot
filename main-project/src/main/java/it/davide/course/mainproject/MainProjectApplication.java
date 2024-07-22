package it.davide.course.mainproject;

import it.davide.course.mainproject.dao.InstructorDao;
import it.davide.course.mainproject.entity.instructor.Instructor;
import it.davide.course.mainproject.entity.instructor.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(
//		scanBasePackages = {"it.davide.course.mainproject",
//		"it.davide.course.util"}
//)
@SpringBootApplication
public class MainProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao) {
		return runner -> {
			//createInstructor(instructorDao);
			//findInstructor(instructorDao);
			//deleteInstructor(instructorDao);
			//findInstructorDetail(instructorDao);
			deleteInstructorDetail(instructorDao);
		};
	}

	private void deleteInstructorDetail(InstructorDao instructorDao) {
		int id = 3;
		instructorDao.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(InstructorDao instructorDao) {
		int id = 3;
		InstructorDetail instructorDetail = instructorDao.findInstructorDetailById(id);
		System.out.println("Instructor detail: " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor());

	}

	private void deleteInstructor(InstructorDao instructorDao) {
		int id = 2;
		instructorDao.deleteById(id);
	}

	private void findInstructor(InstructorDao instructorDao) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		System.out.println("Instructor: " + instructorDao.findById(id));
	}

	private void createInstructor(InstructorDao instructorDao) {
		Instructor instructor = new Instructor(
				"Davide",
				"Strianese",
				"strianese@gmail.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.youtube.com/@Zeb89",
				"Mi piace fare cose"
		);

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Instructor created: " + instructor);
		instructorDao.save(instructor);
	}

}
