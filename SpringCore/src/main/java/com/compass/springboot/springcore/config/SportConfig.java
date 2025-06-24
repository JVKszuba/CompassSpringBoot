package com.compass.springboot.springcore.config;

import com.compass.springboot.springcore.common.Coach;
import com.compass.springboot.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swin")
    public Coach swimCoach() {

        return new SwimCoach();
    }
}
