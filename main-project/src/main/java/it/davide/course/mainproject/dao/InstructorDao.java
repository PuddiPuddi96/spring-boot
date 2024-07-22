package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.instructor.Course;
import it.davide.course.mainproject.entity.instructor.Instructor;
import it.davide.course.mainproject.entity.instructor.InstructorDetail;

import java.util.List;

public interface InstructorDao {

    void save(Instructor instructor);
    Instructor findById(int id);
    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int instructorId);

}
