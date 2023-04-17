package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.*;
import com.example.SpringBoot.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/login/{email}/{password}")
    public Admin login(@PathVariable String email, @PathVariable String password) {
        return adminService.login(email, password);
    }


    @GetMapping("/clinics")
    public List<Clinic> getAllClinics() {
        return adminService.getAllClinics();
    }
    @PostMapping("/clinics")
    public Clinic addClinic(@RequestBody Clinic clinic) {
        return adminService.addClinic(clinic);
    }

    @DeleteMapping("/clinics/{id}")
    public void deleteClinic(@PathVariable Long id) {
        adminService.deleteClinic(id);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return adminService.getAllAppointments();
    }

    @DeleteMapping("/appointments/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        adminService.deleteAppointment(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback() {
        return adminService.getAllFeedback();
    }

    @PostMapping("/feedback/{id}")
    public Feedback replyToFeedback(@PathVariable Long id, @RequestBody Feedback reply) {
        return adminService.replyToFeedback(id, reply);
    }
}
