package it.davide.course.mainproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo-security-controller")
public class DemoSecurityController {

    @GetMapping("/")
    public String showHome() {
        return "security/home";
    }

    @GetMapping("/leaders")
    public String showLeaders() {
        return "security/leaders";
    }

    @GetMapping("/systems")
    public String showSystems() {
        return "security/systems";
    }
}
