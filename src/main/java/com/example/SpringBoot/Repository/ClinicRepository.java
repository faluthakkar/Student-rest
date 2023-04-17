package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Entity.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic,Integer> {
}
