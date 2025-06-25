package com.compass.springboot.hibernatecrud;

import com.compass.springboot.hibernatecrud.dao.StudentDAO;
import com.compass.springboot.hibernatecrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {

            //createStudent(studentDAO);

            //readStudent(studentDAO);

            //queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findByLastName("Doe");

        for (Student student : students) {System.out.println(student);}
    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findAll();

        for (Student student : students) {System.out.println(student);}
    }

    private void readStudent(StudentDAO studentDAO) {

        int id = createStudent(studentDAO);

        System.out.println("Retrieving student data with id ...");
        Student student = studentDAO.findById(id);

        System.out.println("Found the student: " + student);
    }

    private int createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student student = new Student("Paul", "Doe", "paul@gmail.com");

        System.out.println("Saving student object ...");
        studentDAO.save(student);

        int id = student.getId();
        System.out.println("Saved student. Generated id: " + id);

        return id;
    }
}
