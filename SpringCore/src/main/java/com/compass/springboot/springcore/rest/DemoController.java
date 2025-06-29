package com.compass.springboot.springcore.rest;

import com.compass.springboot.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("swin") Coach theCoach, @Qualifier("cricketCoach") Coach theAnotherCoach) {

        System.out.println("In constructor: " + this.getClass().getSimpleName());

        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String getCheck() {

        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
