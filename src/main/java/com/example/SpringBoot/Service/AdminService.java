package com.example.SpringBoot.Service;

import com.example.SpringBoot.Entity.*;

import java.util.List;

public interface AdminService {

    Admin login(String email, String password);
    List<Clinic> getAllClinics();
    Clinic addClinic(Clinic clinic);
    void deleteClinic(Long id);
    List<Appointment> getAllAppointments();
    void deleteAppointment(Long id);
    List<User> getAllUsers();
    List<Feedback> getAllFeedback();
    Feedback replyToFeedback(Long feedbackId, Feedback reply);
    /* the Admin Service Layer has methods for logging in an admin, managing clinics,
    managing appointments, managing users, and managing feedback.

     */
}
