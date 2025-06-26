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

    @Override
    public Employee findById(int id) {

        TypedQuery<Employee> query = em.createQuery("from Employee e where e.id = :id", Employee.class);

        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public Employee save(Employee employee) {

        Employee emp = em.merge(employee);

        return emp;
    }

    @Override
    public void deleteById(Employee employee) {

        Employee emp = em.find(Employee.class, employee.getId());

        em.remove(emp);
    }
}
