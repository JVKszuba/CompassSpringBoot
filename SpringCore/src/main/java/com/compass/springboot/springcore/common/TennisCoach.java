package com.compass.springboot.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {

        return "Practice your backhand volley";
    }
}
