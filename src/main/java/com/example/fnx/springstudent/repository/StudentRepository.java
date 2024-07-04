package com.example.fnx.springstudent.repository;

import com.example.fnx.springstudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository необязательно указывать так как наследуемся от Jpa
public interface StudentRepository extends JpaRepository<Student, Long> {

    void deleteByEmail(String email);

    Student findByEmail(String email);

}
