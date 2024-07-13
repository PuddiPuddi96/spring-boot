package it.davide.course.mainproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestDemoController {

    @GetMapping("/hello")
    public String hello() {
        return "hello World!";
    }
}
