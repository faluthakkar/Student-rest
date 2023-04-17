package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Admin;
import com.example.SpringBoot.Entity.Appointment;
import com.example.SpringBoot.Entity.Feedback;
import com.example.SpringBoot.Entity.User;
import com.example.SpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{email}/{password}")
    public User login(@PathVariable String email, @PathVariable String password) {
        return userService.login(email, password);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointmentsByUser() {
        return userService.getAppointmentsByUser();
    }


    @PostMapping("/appointments/{userId}/{clinicId}")
    public Appointment bookAppointment(@PathVariable Long userId, @PathVariable Long clinicId, @RequestBody Appointment appointment) {
        return userService.bookAppointment(userId, clinicId, appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        userService.cancelAppointment(id);
    }

    @PostMapping("/feedback/{userId}")
    public Feedback addFeedback(@PathVariable Long userId, @RequestBody Feedback feedback) {
        return userService.addFeedback(userId, feedback);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
