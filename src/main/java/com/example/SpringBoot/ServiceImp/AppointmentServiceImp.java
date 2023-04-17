package com.example.SpringBoot.ServiceImp;

import com.example.SpringBoot.Entity.Appointment;
import com.example.SpringBoot.Entity.Clinic;
import com.example.SpringBoot.Entity.User;
import com.example.SpringBoot.Repository.AppointmentRepository;
import com.example.SpringBoot.Repository.ClinicRepository;
import com.example.SpringBoot.Repository.UserRepository;
import com.example.SpringBoot.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImp implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    public List<Appointment> getAllAppointments() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByUser(Long userId) {
        return appointmentRepository.findByUserId(userId);

    }

    public List<Appointment> getAppointmentsByClinic(Long clinicId) {
        return appointmentRepository.findByClinicId(clinicId);
    }

    public Appointment bookAppointment(Long userId, Long clinicId, Appointment appointment) {
        User user = userRepository.findById(Math.toIntExact(userId)).orElse(null);
        Clinic clinic = clinicRepository.findById(Math.toIntExact(clinicId)).orElse(null);

        appointment.setUser(user);
        appointment.setClinic(clinic);

        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(Math.toIntExact(id));
    }
}
