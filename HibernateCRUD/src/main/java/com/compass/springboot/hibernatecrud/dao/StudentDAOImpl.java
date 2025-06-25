package com.compass.springboot.hibernatecrud.dao;

import com.compass.springboot.hibernatecrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {

        this.entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class, id);
    }

}
