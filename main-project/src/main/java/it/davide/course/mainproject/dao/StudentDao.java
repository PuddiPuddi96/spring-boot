package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
