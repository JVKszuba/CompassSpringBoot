package com.compass.springboot.restcrud.rest;

import com.compass.springboot.restcrud.dao.EmployeeDAO;
import com.compass.springboot.restcrud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {

        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }
}
