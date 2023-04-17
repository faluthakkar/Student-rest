package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer> {
    Admin findByEmailAndPassword(String email, String password);
}
