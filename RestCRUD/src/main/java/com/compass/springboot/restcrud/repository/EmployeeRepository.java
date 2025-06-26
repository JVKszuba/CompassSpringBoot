package com.compass.springboot.restcrud.repository;

import com.compass.springboot.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
