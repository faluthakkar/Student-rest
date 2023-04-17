package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {
    List<Appointment> findByUserId(Long userId);

    List<Appointment> findByClinicId(Long clinicId);
}
