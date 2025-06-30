package com.compass.springboot.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("time", java.time.LocalDateTime.now());

        return "helloworld.backup";
    }
}
