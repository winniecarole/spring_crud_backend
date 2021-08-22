package com.example.crud_controller;

import com.example.crud_model.Student;
import com.example.crud_repository.StudentRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository  studentRepository;

    //get all Student
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
