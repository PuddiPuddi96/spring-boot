package it.davide.course.mainproject.rest;

import it.davide.course.mainproject.inter.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    //Inject properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //endpoint for properties
    @GetMapping("/info-pro")
    public String info() {
        return "Coach: " + coachName + " Team:" + teamName;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/workout")
    public String workout() {
        return "Go to the gym!";
    }

    /**
     * ---------------------------------------------
     */

    private final Coach myCoach;

    @Autowired
    public TempController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
