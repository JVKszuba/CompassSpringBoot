package com.compass.springboot.hibernatecrud.dao;

import com.compass.springboot.hibernatecrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> query = entityManager.createQuery("from Student s", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> query = entityManager.createQuery("from Student s " +
                                                                        "where s.lastName = :lastName", Student.class);

        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {

        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        return entityManager.createQuery("delete from Student").executeUpdate();
    }
}
