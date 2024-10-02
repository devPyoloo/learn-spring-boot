package com.learning.learn_spring_boot.repository;

import com.learning.learn_spring_boot.model.Student;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    private final StudentRepository studentRepository;

    @Autowired
    StudentRepositoryTest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    @Transactional
    public void toSave() {
        //provide value
        Student student = new Student();
        student.setName("Yasmin");
        student.setDob(LocalDate.of(2002, Month.FEBRUARY, 2));
        student.setEmail("yasmin@gmail.com");

        // save student
        Student savedStudent = studentRepository.save(student);
        assertNotNull(savedStudent.getId());
    }


    @Test
    @Transactional
    public void updateStudent() { // you can pass a argument here: (Long id, String newName)
        // Check if the student exists
        Optional<Student> optionalStudent = studentRepository.findById(1L); // example only but the id should come from client.

        if (optionalStudent.isPresent()) {
            // Retrieve the existing student
            Student student = optionalStudent.get();

            // Update entity information
            student.setName("Yasmin Soba");
            student.setEmail("yasminnn@gmail.com");

            // Save updated entity
            studentRepository.save(student);
        } else {
            // Handle the case where the student does not exist
            throw new EntityNotFoundException("Student with ID " + 1L + " not found.");
        }
    }

    // Retrive a single entity from MySQL database (Select query)
    @Test
    @Transactional
    public void findByIdMethod() {
        Optional<Student> optionalStudent = studentRepository.findById(1L);

        if (optionalStudent.isPresent()) {
            // Retrieve the existing student
            Student student = optionalStudent.get();
        } else {
            // Handle the case where the student does not exist
            throw new EntityNotFoundException("Student with ID " + 1L + " not found.");
        }
    }

//     Retrieves all the entities in the MySQL Database Table.
    @Test
    @Transactional
    public void findAllMethod() {
        List<Student> students = studentRepository.findAll();

        students.forEach((student) -> System.out.println(student.getName() + student.getAge()));
    }


//    Save multiple entities to MySQL Database.
    @Test
//    @Transactional
    public void saveAllMethod() {
        Student student4 = new Student();
            student4.setName("Mark Piolooooooo");
            student4.setDob(LocalDate.of(2002, Month.FEBRUARY, 4));
            student4.setEmail("markkkkk@gmail.com");

        Student student5 = new Student();
        student5.setName("Lotso Dos Pascualllllll");
        student5.setDob(LocalDate.of(2002, Month.FEBRUARY, 2));
        student5.setEmail("lotsodossssss@gmail.com");

         studentRepository.saveAll(List.of(student4, student5));
    }

    // Delete an entity by Id in database.
    @Test
    @Transactional
    public void deleteByIdStudent() {
        Long id = 4L;
        studentRepository.deleteById(id);
    }

// Delete a single entity from MySQL database
    @Test
public void deleteMethod() {
       Long id = 13L;

       Optional<Student> optionalStudent = studentRepository.findById(id);

       if(optionalStudent.isPresent()) {
           Student student = optionalStudent.get();

           studentRepository.delete(student);
       } else {
           throw new EntityNotFoundException("Student with ID " + id + " not found.");
       }

}

// Delete multiple entities from MySQL database.
// Efficient if the intent is to remove all records from a table.
    @Test
public void deleteAllMethod() {
        studentRepository.deleteAll();
}


// Delete all entities that takes list of retrieval objects.
// Can specify exactly which entities to delete, which makes it safer and more appropriate when you only want to delete specific records.
@Test
    public void deleteAllMethodWithReturnObjects() {
       List<Long> idsToDelete = List.of(12L, 13L);

       studentRepository.deleteAllByIds(idsToDelete);
}

// Count methods allows us to counts the number of records that exists in database table(tbl_students).
    @Test
    public void countMethod() {
        long count = studentRepository.count();

        System.out.println("Total numbers of Student " + count);
    }

    // Checks if an Entity exist in database table.
    @Test
    public void checkIfIdExist() {
        Long id = 15L;

        boolean exist = studentRepository.existsById(id);
        System.out.println(exist);
    }
}