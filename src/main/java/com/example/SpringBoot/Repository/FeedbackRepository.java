package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Integer> {
}
