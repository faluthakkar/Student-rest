package com.example.SpringBoot.Service;

import com.example.SpringBoot.Entity.Admin;
import com.example.SpringBoot.Entity.Appointment;
import com.example.SpringBoot.Entity.Feedback;
import com.example.SpringBoot.Entity.User;

import java.util.List;

public interface UserService {
    User login(String email, String password);
    User registerUser(User user);
    User getUserByEmail(String email);
    List<Appointment> getAppointmentsByUser();
    Appointment bookAppointment(Long userId, Long clinicId, Appointment appointment);
    void cancelAppointment(Long id);
    Feedback addFeedback(Long userId, Feedback feedback);
    List<User> getAllUsers();
}
