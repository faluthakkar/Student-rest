package com.example.SpringBoot.Service;

import com.example.SpringBoot.Entity.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByUser(Long userId);
    List<Appointment> getAppointmentsByClinic(Long clinicId);
    Appointment bookAppointment(Long userId, Long clinicId, Appointment appointment);
    void cancelAppointment(Long id);

    /*In this code, the Appointment Service Layer has methods
    for getting all appointments, getting appointments by user,
    getting appointments by clinic, booking an appointment,
    and cancelling an appointment. The methods use the repositories for the Appointment, User,
     and Clinic entities to perform the database operations.
     */
}
