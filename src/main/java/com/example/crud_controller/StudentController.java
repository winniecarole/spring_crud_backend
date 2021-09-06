package com.example.crud_controller;

import com.example.crud_execption.ResourceNotFoundException;
import com.example.crud_model.Student;
import com.example.crud_repository.StudentRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository  studentRepository;

    //get all Student
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    //create Student rest api
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //get employee by id rest api
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student=studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Student not exist with id :"+id)
        );
        return ResponseEntity.ok(student);
    }

    //update Student
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id , @RequestBody Student studentDetails){
        Student student=studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Student not exist with id :"+id)
        );
       student.setFirstName(studentDetails.getFirstName());
       student.setLastName(studentDetails.getLastName());
       student.setEmail(studentDetails.getEmail());

       Student updateStudent=studentRepository.save(student);
       return ResponseEntity.ok(updateStudent);
    }

    //delete Student rest api
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Map> deleteStudent(@PathVariable Long id){
        Student student=studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Student not exist with id :"+id));

        studentRepository.delete(student);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
