package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Repository.StudentRepository;
import com.example.SpringBoot.Service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith( SpringExtension.class)
@WebMvcTest(StudentController.class)
public class StudentTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void testGetAllStudent() throws Exception {
        List<Student> listStudent = new ArrayList<Student>();
        listStudent.add(new Student(1L,"Falguni","Thakkar","falu@gmail.com"));
        listStudent.add(new Student(2L,"Chirag","Thakkar","chirag@gmail.com"));
        listStudent.add(new Student(3L,"Priti","Thakkar","priti@gmail.com"));
        listStudent.add(new Student(4L,"Dhwit","Thakkar","dhwit@gmail.com"));
        listStudent.add(new Student(5L,"Ankita","Thakkar","ankita@gmail.com"));
        Mockito.when(studentService.getAllStudents()).thenReturn(listStudent);
        MvcResult mvcGetResult = mockMvc.perform(get("/student")).andExpect(status().isOk()).andReturn();
        byte[] bytes = mvcGetResult.getResponse().getContentAsByteArray();
        Path path = Paths.get("studentList.xls");
        Files.write(path, bytes);
    }



    @Test
    public void testDeleteStudentById() throws Exception {
        mockMvc.perform(delete("/student/{id}", 1))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetStudentById() throws Exception {
        int id = 1;
        Student student = new Student((long) id,"John","Doe","john@gmail.com");
        Mockito.when(studentService.getStudentById((long) id)).thenReturn(Optional.of(student));
        mockMvc.perform(get("/student/{id}", id))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value(id))
                .andExpect((ResultMatcher) jsonPath("$.firstName").value(student.getFirstName()))
                .andExpect((ResultMatcher) jsonPath("$.lastName").value(student.getLastName()))
                .andExpect((ResultMatcher) jsonPath("$.email").value(student.getEmail()))
                .andDo(print());
    }
}
