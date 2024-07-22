package it.davide.course.mainproject;

import it.davide.course.mainproject.dao.InstructorDao;
import it.davide.course.mainproject.entity.instructor.Course;
import it.davide.course.mainproject.entity.instructor.Instructor;
import it.davide.course.mainproject.entity.instructor.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//deleteInstructorDetail(instructorDao);
			//createInstructorWithCourses(instructorDao);
			//findInstructorWIthCourses(instructorDao);
			//findCoursesForInstructor(instructorDao);
			//findInstructorWIthCoursesJoinFetch(instructorDao);
			//updateInstructor(instructorDao);
			//updateCourse(instructorDao);
			deleteCourse(instructorDao);
		};
	}

	private void deleteCourse(InstructorDao instructorDao) {
		instructorDao.deleteCourseById(10);
	}

	private void updateCourse(InstructorDao instructorDao) {
		int id = 10;

		Course course = instructorDao.findCourseById(id);
		System.out.println("Course to update: " + course);

		course.setTitle("Non sai come studiarmi");
		instructorDao.updateCourse(course);
	}

	private void updateInstructor(InstructorDao instructorDao) {
		int id = 1;

		Instructor instructor = instructorDao.findById(id);
		System.out.println("Instructor to update: " + instructor);

		instructor.setFirstName("Lautaro");
		instructor.setLastName("Martinez");

		instructorDao.update(instructor);
	}

	private void findInstructorWIthCoursesJoinFetch(InstructorDao instructorDao) {
		int id = 1;

		Instructor instructor = instructorDao.findInstructorByJoinFetch(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(InstructorDao instructorDao) {
		int id = 1;

		Instructor instructor = instructorDao.findById(id);
		System.out.println("Instructor: " + instructor);

		List<Course> courses = instructorDao.findCoursesByInstructorId(id);

		instructor.setCourses(courses);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findInstructorWIthCourses(InstructorDao instructorDao) {
		int id = 1;
		Instructor instructor = instructorDao.findById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(InstructorDao instructorDao) {
		Instructor instructor = new Instructor(
				"Lucio",
				"Di Michele",
				"dimichele@gmail.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.youtube.com/@Zeb89",
				"Mi piace fare cose"
		);

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Corso 1");
		Course course2 = new Course("Corso 2");
		Course course3 = new Course("Corso 3");

		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		System.out.println("Saving instructor: " + instructor);
		instructorDao.save(instructor);
	}

	private void deleteInstructorDetail(InstructorDao instructorDao) {
		int id = 4;
		instructorDao.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(InstructorDao instructorDao) {
		int id = 3;
		InstructorDetail instructorDetail = instructorDao.findInstructorDetailById(id);
		System.out.println("Instructor detail: " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor());

	}

	private void deleteInstructor(InstructorDao instructorDao) {
		int id = 1;
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
