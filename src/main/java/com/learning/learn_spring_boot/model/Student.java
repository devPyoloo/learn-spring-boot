package com.learning.learn_spring_boot.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

//  Marks a class as an entity, meaning it represents a table in the database.
@Entity
// @Table annotations specifies the table name in the database that this entity is mapped to
@Table(name = "tbl_students",
        schema = "students",
        uniqueConstraints = {
        @UniqueConstraint( name = "email_unique", // prevent data duplication. You can add more (e.g if you want unique name)
                            columnNames = "email"),
        @UniqueConstraint( name = "name_unique",
                            columnNames = "name")
        })
public class Student {
    @Id // Marks a field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies how the primary key (id) should be generated, relies on database auto-increment.
    private Long id;

    @Column(nullable = true) // means column can accept NULL values, indicating that it's optional.
    private String name;
    private Integer age;
    private LocalDate dob;

    @CreationTimestamp // will automatically set the timestamp when a new record is inserted into the database.
    private LocalDate dateCreated;

    @UpdateTimestamp // automatically set the timestamp when a new record is inserted.
    private LocalDate lastUpdated;
    @Column(nullable = false) // means column must always have a value and cannot be left empty. Cause error if empty or no value
    private String email;

    // Default constructor required or requirement of JPA/Hibernate for entity management.
    public Student() {
    }

    // Id included, useful when updating existing Student records.


    // Constructor for updating existing student
    public Student(Long id, String name, Integer age, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    // practical for new Student since database auto generate Id (primary key).
    public Student(String name, Integer age, LocalDate dob, String email) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // No setter to prevent overwriting since Hibernate handles the timestamp automatically
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    // No setter to prevent overwriting since Hibernate handles the timestamp automatically
    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", email='" + email + '\'' +
                '}';
    }
}
