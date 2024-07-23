package it.davide.course.mainproject.dao;

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

    Course findCourseById(int id);
    void updateCourse(Course course);
    void deleteCourseById(int id);

    void save(Course course);
    Course findCourseAndReviewsById(int id);


}
