package com.compass.springboot.springcore.common;

public class SwimCoach implements Coach {

    public SwimCoach() {

        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Swim 1000 meters as a warm up";
    }
}
