package com.project.llt.service;

import com.project.llt.model.Feedback;
import java.util.List;

public interface FeedbackService {
    
    List<Feedback> getAllFeedbacks();
    
    Feedback getFeedbackById(Long id);
    
    Feedback saveFeedback(Feedback feedback);
    
    Feedback updateFeedbackById(Feedback feedback, Long id);
    
    void deleteFeedbackById(Long id);
}
