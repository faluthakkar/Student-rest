package com.example.SpringBoot.ServiceImp;

import com.example.SpringBoot.Entity.*;
import com.example.SpringBoot.Repository.*;
import com.example.SpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;


    @Override
    public User login(String email, String password) {

            Optional<User> user = Optional.ofNullable(userRepository.findByEmailAndPassword(email, password));
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new RuntimeException("Incorrect email or password");
            }
        }


    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Appointment> getAppointmentsByUser() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    public Appointment bookAppointment(Long userId, Long clinicId, Appointment appointment) {
        User user = userRepository.findById(Math.toIntExact(userId)).orElse(null);
        Clinic clinic = clinicRepository.findById(Math.toIntExact(clinicId)).orElse(null);
        appointment.setUser(user);
        appointment.setClinic(clinic);

        Appointment savedAppointment = appointmentRepository.save(appointment);
   //     receiptRepository.save(new Receipt(savedAppointment));

        return savedAppointment;
    }

    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(Math.toIntExact(id));
    }

    public Feedback addFeedback(Long userId, Feedback feedback) {
        User user = userRepository.findById(Math.toIntExact(userId)).orElse(null);
        feedback.setUser(user);
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}

