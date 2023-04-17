package com.example.SpringBoot.Service;

import com.example.SpringBoot.Entity.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> getAllClinics();
    Clinic addClinic(Clinic clinic);
    void deleteClinic(Long id);
}
