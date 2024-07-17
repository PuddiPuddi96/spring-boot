package it.davide.course.mainproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //Method to show HTML form
    @GetMapping("/show-form")
    public String showForm() {
        return "hello-world-form";
    }

    //Method to precess the HTML form
    @RequestMapping("/process-form")
    public String processForm() {
        return "hello-world";
    }

    @RequestMapping("/process-form-2")
    public String processForm2(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        name = "YO! " + name;

        model.addAttribute("message", name);

        return "hello-world";
    }

    @PostMapping("/process-form-3")
    public String processForm3(
            @RequestParam("studentName") String studentName,
            Model model) {

        studentName = "Hey my friend from v3! " + studentName.toUpperCase();

        model.addAttribute("message", studentName);

        return "hello-world";
    }
}
