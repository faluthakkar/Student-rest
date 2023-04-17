package com.example.SpringBoot.Entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class Appointment {
    private static final double CHARGE_PER_MINUTE =10 ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;


    private Date date;

    @Column(name = "start")
    private Date startTime;

    @Column(name = "end")
    private Date endTime;





    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Appointment(Long id, User user, Clinic clinic, Date date, Date startTime, Date endTime) {
        this.id = id;
        this.user = user;
        this.clinic = clinic;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double calculateTotalCharge() {
        double totalCharge = 0;
        if (endTime != null) {
            double timeSpent = endTime.getTime() - startTime.getTime();
            totalCharge = (timeSpent * CHARGE_PER_MINUTE)/100;
        }
        return totalCharge;

    }

   

}