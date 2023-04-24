package com.example.SpringBoot.Service;

import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);
    Optional<Student> getStudentById(Long id) throws ResourceNotFoundException;
    Student updateStudent(Student student,Integer id) throws ResourceNotFoundException;
    void deleteStudentById(Long id) throws ResourceNotFoundException;

}
