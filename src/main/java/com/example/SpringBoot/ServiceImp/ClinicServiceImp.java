package com.example.SpringBoot.ServiceImp;

import com.example.SpringBoot.Entity.Clinic;
import com.example.SpringBoot.Repository.ClinicRepository;
import com.example.SpringBoot.Service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImp implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;


    public List<Clinic> getAllClinics() {
        return (List<Clinic>) clinicRepository.findAll();
    }

    public Clinic addClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(Math.toIntExact(id));
    }
}
