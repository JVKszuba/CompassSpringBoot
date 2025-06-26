package com.compass.springboot.restcrud.dao;

import com.compass.springboot.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    EntityManager em;

    @Autowired
    EmployeeDAOImpl(EntityManager entityManager) {

        this.em = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = em.createQuery("from Employee e", Employee.class);

        return query.getResultList();
    }
}
