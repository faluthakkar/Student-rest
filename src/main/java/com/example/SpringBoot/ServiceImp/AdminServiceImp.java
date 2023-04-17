package com.example.SpringBoot.ServiceImp;

import com.example.SpringBoot.Entity.*;
import com.example.SpringBoot.Repository.*;
import com.example.SpringBoot.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp  implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    public Admin login(String email, String password) {
        Optional<Admin> adminOptional = Optional.ofNullable(adminRepository.findByEmailAndPassword(email, password));
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        } else {
            throw new RuntimeException("Incorrect email or password");
        }
    }

    public List<Clinic> getAllClinics() {
        return (List<Clinic>) clinicRepository.findAll();
    }

    public Clinic addClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(Math.toIntExact(id));
    }

    public List<Appointment> getAllAppointments() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(Math.toIntExact(id));
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public List<Feedback> getAllFeedback() {
        return (List<Feedback>) feedbackRepository.findAll();
    }

    public Feedback replyToFeedback(Long feedbackId, Feedback reply) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(Math.toIntExact(feedbackId));
        if (feedbackOptional.isPresent()) {
            Feedback feedback = feedbackOptional.get();
            feedback.setReply(reply.getReply());
            return feedbackRepository.save(feedback);
        } else {
            throw new RuntimeException("Feedback not found");
        }

    }
}
