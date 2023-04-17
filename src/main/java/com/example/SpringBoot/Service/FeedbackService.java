package com.example.SpringBoot.Service;

import com.example.SpringBoot.Entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedback();
    Feedback addFeedback(Long userId, Feedback feedback);
}
