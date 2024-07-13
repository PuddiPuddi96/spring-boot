package it.davide.spring.bsp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {

    @GetMapping(value = "/test")
    public String simple() {
        return "Hello World";
    }
}
