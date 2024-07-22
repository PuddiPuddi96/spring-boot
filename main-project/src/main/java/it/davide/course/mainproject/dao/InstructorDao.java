package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.instructor.Instructor;
import it.davide.course.mainproject.entity.instructor.InstructorDetail;

public interface InstructorDao {

    void save(Instructor instructor);
    Instructor findById(int id);
    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);

}
