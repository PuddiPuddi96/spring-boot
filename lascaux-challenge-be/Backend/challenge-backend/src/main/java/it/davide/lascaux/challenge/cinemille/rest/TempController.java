package it.davide.lascaux.challenge.cinemille.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/temp")
public class TempController {

    @GetMapping(value = "/test")
    public String simple() {
        return "Hello World";
    }
}
