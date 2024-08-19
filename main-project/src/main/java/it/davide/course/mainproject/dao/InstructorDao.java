package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.Student;
import it.davide.course.mainproject.entity.instructor.Course;
import it.davide.course.mainproject.entity.instructor.Instructor;
import it.davide.course.mainproject.entity.instructor.InstructorDetail;

import java.util.List;

public interface InstructorDao {

    void save(Instructor instructor);
    Instructor findById(int id);
    void update(Instructor instructor);
    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int instructorId);
    Instructor findInstructorByJoinFetch(int id);

    void save(Course course);
    Course findCourseById(int id);
    void updateCourse(Course course);
    void deleteCourseById(int id);

    Course findCourseAndReviewsById(int id);
    Course findCourseAndStudentsById(int id);

    Student findStudentAndCoursesById(int id);
    void update(Student student);
    void deleteStudent(int id);

}
