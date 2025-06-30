package com.compass.springboot.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
