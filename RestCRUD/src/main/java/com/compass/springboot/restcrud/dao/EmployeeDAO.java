package com.compass.springboot.restcrud.dao;

import com.compass.springboot.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
