package com.example.crud_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crud_model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
