package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Clinic;
import com.example.SpringBoot.Service.ClinicService;
import com.example.SpringBoot.ServiceImp.ClinicServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping
    public List<Clinic> getAllClinics() {
        return clinicService.getAllClinics();
    }

    @PostMapping
    public Clinic addClinic(@RequestBody Clinic clinic) {
        return clinicService.addClinic(clinic);
    }

    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinic(id);
    }
}
