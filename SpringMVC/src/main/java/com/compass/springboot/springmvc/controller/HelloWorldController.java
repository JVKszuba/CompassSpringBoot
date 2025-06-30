package com.compass.springboot.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {

        return "helloworld_form";
    }

    @RequestMapping("/processForm")
    public String processForm() {

        return "helloworld";
    }
    
    @RequestMapping("/processFormUpperCase")
    public String processFormUpperCase(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName").toUpperCase();

        model.addAttribute("message", name);

        return "helloworld";
    }

    @RequestMapping("/processFormRequestParam")
    public String processFormRequestParam(@RequestParam("studentName") String name, Model model) {

        name = name.toUpperCase();

        String result = "Hey my friend " + name;

        model.addAttribute("message", result);

        return "helloworld";

    }
}
