package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Feedback;
import com.example.SpringBoot.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @PostMapping("/user/{userId}")
    public Feedback addFeedback(@PathVariable Long userId, @RequestBody Feedback feedback) {
        return feedbackService.addFeedback(userId, feedback);
    }
}
