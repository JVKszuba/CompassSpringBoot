package com.compass.springboot.restsecurity.service;

import com.compass.springboot.restsecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<com.compass.springboot.restsecurity.entity.Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
