package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Exception.ResourceNotFoundException;
import com.example.SpringBoot.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //create rest api to save student
    @PostMapping("/student")
    public Student save(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    //rest api to get All students
    @GetMapping("/student")
    public List<Student> getAllConsumers(){
        return studentService.getAllStudents();
    }

    //rest api to get student by id
    @GetMapping("/student/{id}")
    public Optional<Student> getById(@PathVariable Integer id) throws ResourceNotFoundException {
        return studentService.getStudentById(Long.valueOf(id));
    }

    //rest api to delete by id
    @DeleteMapping("/student/{id}")
    public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
        studentService.deleteStudentById(Long.valueOf(id));
    }

    //rest api to update student
    @PutMapping("/student/{id}")
    public Student update(@RequestBody Student student, @PathVariable	Integer id) throws ResourceNotFoundException {
        return studentService.updateStudent(student,id);
    }

}
