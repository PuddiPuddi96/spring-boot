package it.davide.course.mainproject.rest;

import it.davide.course.mainproject.entity.StudentPojo;
import it.davide.course.mainproject.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<StudentPojo> students;

    @PostConstruct
    private void loadStudents(){
        students = new ArrayList<>();

        students.add(new StudentPojo("Davide", "Strianese"));
        students.add(new StudentPojo("Luca", "Strianese"));
        students.add(new StudentPojo("Gerardina", "Cortese"));
    }

    @GetMapping("/students")
    public List<StudentPojo> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public StudentPojo getStudent(@PathVariable int studentId) {

        //fake check for studentId
        if(studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return students.get(studentId);
    }
}
