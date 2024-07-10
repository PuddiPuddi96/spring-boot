package it.davide.course.mainproject.config;

import it.davide.course.mainproject.common.Coach;
import it.davide.course.mainproject.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean(value = "aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
