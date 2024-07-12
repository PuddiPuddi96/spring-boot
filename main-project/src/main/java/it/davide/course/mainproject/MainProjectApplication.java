package it.davide.course.mainproject;

import it.davide.course.mainproject.dao.StudentDao;
import it.davide.course.mainproject.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			//createStudent(studentDao);
			createMultipleStudent(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAll(studentDao);
		};
	}

	private void deleteAll(StudentDao studentDao) {
		System.out.println("Deleted row count: " + studentDao.deleteAll());
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		int studentId = 1;
		Student student = studentDao.findById(studentId);

		student.setFirstName("Paoletto");
		studentDao.update(student);

		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		List<Student> students = studentDao.findByLastName("Strianese");
		students.forEach(System.out::println);
	}

	private void queryForStudents(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();
		students.forEach(System.out::println);
	}

	private void readStudent(StudentDao studentDao) {
		Student student = new Student("Aurelio", "Esposito", "grandissimo@gmail.com");
		studentDao.save(student);

		int studentId = student.getId();
		System.out.println("Saved student. Generated id: " + studentId);

		Student myStudent = studentDao.findById(studentId);
		System.out.println("Found student: " + myStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		Student student1 = new Student("Altro", "Strianese", "giga@gmail.com");
		Student student2 = new Student("Luca", "Strianese", "luca@gmail.com");
		Student student3 = new Student("Franco", "Strianese", "franco@gmail.com");

		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createStudent(StudentDao studentDao) {
		Student student = new Student("Davide", "Strianese", "puddi@gmail.com");
		studentDao.save(student);
		System.out.println("Saved student. Generated id: " + student.getId());
	}

}
