package it.davide.course.mainproject.classes;

import it.davide.course.mainproject.inter.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
