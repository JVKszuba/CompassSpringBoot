package com.compass.springboot.springmvccrud.repository;

import com.compass.springboot.springmvccrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
