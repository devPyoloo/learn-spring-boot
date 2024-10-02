package com.learning.learn_spring_boot.controller;
import com.learning.learn_spring_boot.model.Student;
import com.learning.learn_spring_boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Simplifies the creation of RESTful APIs by automatically serializing return values to JSON (or XML).
@RequestMapping(path = "api/v1/students") // sets the base path for all the endpoints in this controller to api/v1/students.

public class StudentRestController {
    private final StudentService studentService;


    @Autowired
    public StudentRestController(StudentService studentService) { // Constructor injection this is what i mean injection.
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudent() { // automatically convert the List<Student> into a JSON array. Useful in fetching data in frontend and use axios.
        return studentService.getStudents();
    }

}
