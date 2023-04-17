package com.example.SpringBoot.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Receipt {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "appointment_id")
        private Appointment appointment;
        private String createdAt;

    public Receipt() {

    }

    public Receipt(Appointment appointment) {
        this.appointment=appointment;
        this.createdAt = LocalDateTime.now().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = String.valueOf(createdAt);
    }

    public Receipt(Long id, Appointment appointment, Date createdAt) {
        this.id = id;
        this.appointment = appointment;
        this.createdAt = String.valueOf(createdAt);
    }


}
