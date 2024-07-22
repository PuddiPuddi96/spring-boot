package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.instructor.Instructor;

public interface InstructorDao {

    void save(Instructor instructor);
    Instructor findById(int id);

}
