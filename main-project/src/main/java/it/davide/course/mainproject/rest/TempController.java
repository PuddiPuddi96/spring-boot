package it.davide.course.mainproject.rest;

import it.davide.course.mainproject.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

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

    /**
     * ---------------------------------------------
     */


    private final Coach myCoach;

    //Constructor injection
    @Autowired
    public TempController(
            @Qualifier(value = "aquatic") Coach theCoach){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        myCoach = theCoach;
    }

    //Setter injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
