package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Appointment;
import com.example.SpringBoot.Service.AppointmentService;
import com.example.SpringBoot.ServiceImp.AppointmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/user/{userId}")
    public List<Appointment> getAppointmentsByUser(@PathVariable Long userId) {
        return appointmentService.getAppointmentsByUser(userId);
    }

    @GetMapping("/clinic/{clinicId}")
    public List<Appointment> getAppointmentsByClinic(@PathVariable Long clinicId) {
        return appointmentService.getAppointmentsByClinic(clinicId);
    }

    @PostMapping("/user/{userId}/clinic/{clinicId}")
    public Appointment bookAppointment(@PathVariable Long userId, @PathVariable Long clinicId, @RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(userId, clinicId, appointment);
    }

    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }
}
