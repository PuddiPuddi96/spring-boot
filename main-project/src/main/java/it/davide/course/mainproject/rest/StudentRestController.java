package it.davide.course.mainproject.rest;

import it.davide.course.mainproject.entity.StudentPojo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<StudentPojo> getStudents() {
        return List.of(
                new StudentPojo("Davide", "Strianese"),
                new StudentPojo("Luca", "Strianese"),
                new StudentPojo("Gerardina", "Cortese")
        );
    }
}
