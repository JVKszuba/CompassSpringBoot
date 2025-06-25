package com.compass.springboot.hibernatecrud.dao;

import com.compass.springboot.hibernatecrud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);
}
