package com.learning.learn_spring_boot.service;
import com.learning.learn_spring_boot.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Component // generic stereotype for any Spring-managed component. It can be used for any class that you want to be a Spring bean.
@Service // tells Spring to manage this class as a service bean, enabling dependency injection (can use in controller or any layer). is a specialization of @Component that indicates the class holds business logic or service layer operations.
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L,
                        "Yasmin",
                        22,
                        LocalDate.of(2002, Month.FEBRUARY, 9),
                        "yasminpascual@gmail.com")
        );
    }

}
