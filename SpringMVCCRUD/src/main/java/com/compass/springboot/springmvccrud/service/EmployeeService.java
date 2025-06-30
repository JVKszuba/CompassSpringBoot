package com.compass.springboot.springmvccrud.service;

import com.compass.springboot.springmvccrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
