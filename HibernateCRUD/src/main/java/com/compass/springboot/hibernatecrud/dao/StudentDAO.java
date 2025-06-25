package com.compass.springboot.hibernatecrud.dao;

import com.compass.springboot.hibernatecrud.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);
}
