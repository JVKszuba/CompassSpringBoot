package com.compass.springboot.restsecurity.rest;

import com.compass.springboot.restsecurity.entity.Employee;
import com.compass.springboot.restsecurity.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {

        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee;

        try {employee = employeeService.findById(employeeId);}
        catch (Exception e) {throw new RuntimeException("Employee not found - " + employeeId);}

        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {

        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Map<String, Object> patchPayload, @PathVariable int employeeId) {

        Employee employee;

        try {employee = employeeService.findById(employeeId);}
        catch (Exception e) {throw new RuntimeException("Employee not found - " + employeeId);}

        if(patchPayload.containsKey("id")) {throw new RuntimeException("Employee id not allowed in request body - " + employeeId);}

        Employee patchedEmployee = apply(patchPayload, employee);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee) {

        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee;

        try { employee = employeeService.findById(employeeId);}
        catch (Exception e) {throw new RuntimeException("Employee not found - " + employeeId);}

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
