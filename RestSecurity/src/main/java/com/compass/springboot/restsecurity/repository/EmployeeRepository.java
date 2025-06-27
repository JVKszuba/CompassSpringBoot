package com.compass.springboot.restsecurity.repository;

import com.compass.springboot.restsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
