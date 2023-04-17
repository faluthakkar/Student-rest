package com.example.SpringBoot.ServiceImp;

import com.example.SpringBoot.Entity.Feedback;
import com.example.SpringBoot.Entity.User;
import com.example.SpringBoot.Repository.FeedbackRepository;
import com.example.SpringBoot.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImp implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedback() {
        return (List<Feedback>) feedbackRepository.findAll();
    }

    public Feedback addFeedback(Long userId, Feedback feedback) {
        User user = new User();
        user.setId(userId);
        feedback.setUser(user);
        return feedbackRepository.save(feedback);
    }
}
