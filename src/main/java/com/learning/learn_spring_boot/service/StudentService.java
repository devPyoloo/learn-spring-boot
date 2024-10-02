package com.learning.learn_spring_boot.service;
import com.learning.learn_spring_boot.model.Student;
import com.learning.learn_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Component // generic stereotype for any Spring-managed component. It can be used for any class that you want to be a Spring bean.
@Service // tells Spring to manage this class as a service bean, enabling dependency injection (can use in controller or any layer). is a specialization of @Component that indicates the class holds business logic or service layer operations.
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }
}
