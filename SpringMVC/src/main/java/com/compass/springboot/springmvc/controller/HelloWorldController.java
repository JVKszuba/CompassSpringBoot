package com.compass.springboot.springmvc.controller;

import com.compass.springboot.springmvc.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);

        binder.registerCustomEditor(String.class, stringTrimmer);
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {

        model.addAttribute("student", new Student());

        return "helloworld_form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult result) {

        if (result.hasErrors()) return "helloworld_form";
        else return "helloworld";
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
