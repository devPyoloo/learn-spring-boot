package com.learning.learn_spring_boot.repository;

import com.learning.learn_spring_boot.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.id IN :ids")
    void deleteAllByIds(@Param("ids") List<Long> ids);

}
