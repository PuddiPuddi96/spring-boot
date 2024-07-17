package it.davide.course.mainproject.controller;

import it.davide.course.mainproject.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/show-student-form")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/process-student-form")
    public String processStudentForm(@ModelAttribute("student") Student student) {
        System.out.println("The student: " + student);

        return "student-confirmation";
        //return "redirect:/show-student-form";
    }
}
