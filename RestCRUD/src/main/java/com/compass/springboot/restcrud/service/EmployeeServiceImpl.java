package com.compass.springboot.restcrud.service;

import com.compass.springboot.restcrud.dao.EmployeeDAO;
import com.compass.springboot.restcrud.dao.EmployeeDAOImpl;
import com.compass.springboot.restcrud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO dao;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {

        this.dao = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {

        return dao.findAll();
    }

    @Override
    public Employee findById(int id) {

        return dao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        return dao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Employee employee) {

        dao.deleteById(employee);
    }
}
