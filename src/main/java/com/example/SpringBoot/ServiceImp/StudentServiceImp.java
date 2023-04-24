package com.example.SpringBoot.ServiceImp;

import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Exception.ResourceNotFoundException;
import com.example.SpringBoot.Repository.StudentRepository;
import com.example.SpringBoot.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp  implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) throws ResourceNotFoundException {
         Optional<Student> s = studentRepository.findById(Math.toIntExact(id));
        if (s.isPresent())
            return s;
        else
            throw new ResourceNotFoundException("Student", "Id", id);
    }


    @Override
    public Student updateStudent(Student student, Integer id) throws ResourceNotFoundException {
        Student s = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "Id", id));
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setEmail(student.getEmail());
        studentRepository.save(s);
        return s;
    }

    @Override
    public void deleteStudentById(Long id) throws ResourceNotFoundException {
        if (studentRepository.existsById(Math.toIntExact(id))) {
            studentRepository.deleteById(Math.toIntExact(id));
        } else {
            throw new ResourceNotFoundException("Student", "Id", id);
        }
    }
}
