package com.compass.springboot.springmvccrud.service;

import com.compass.springboot.springmvccrud.entity.Employee;
import com.compass.springboot.springmvccrud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {this.repository = employeeRepository;}

    @Override
    public List<Employee> findAll() {return repository.findAll();}

    @Override
    public Employee findById(int id) {return repository.findById(id).orElseThrow();}

    @Override
    public Employee save(Employee employee) {return repository.save(employee);}

    @Override
    public void deleteById(int id) {repository.deleteById(id);}
}
