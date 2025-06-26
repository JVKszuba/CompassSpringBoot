package com.compass.springboot.restcrud.service;

import com.compass.springboot.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(Employee employee);
}
