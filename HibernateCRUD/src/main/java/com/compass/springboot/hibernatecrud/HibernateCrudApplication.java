package com.compass.springboot.hibernatecrud;

import com.compass.springboot.hibernatecrud.dao.StudentDAO;
import com.compass.springboot.hibernatecrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> createStudent(studentDAO);
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student student = new Student("Paul", "Doe", "paul@gmail.com");

        System.out.println("Saving student object ...");
        studentDAO.save(student);

        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
