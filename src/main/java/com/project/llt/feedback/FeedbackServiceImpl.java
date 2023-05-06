package com.project.llt.feedback;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDao feedbackDao;

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.findAll();
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Feedback with id %s was not found", id)));
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackDao.save(feedback);
    }

    @Override
    public Feedback updateFeedbackById(Feedback feedback, Long id) {
        Feedback feedbackToUpdate = getFeedbackById(id);
        feedbackToUpdate.setType(feedback.getType());
        feedbackToUpdate.setDescription(feedback.getDescription());
        feedbackToUpdate.setSentAt(feedback.getSentAt());
        feedbackToUpdate.setUser(feedback.getUser());
        return feedbackDao.update(feedbackToUpdate);
    }

    @Override
    public void deleteFeedbackById(Long id) {
        Feedback feedbackToDelete = getFeedbackById(id);
        feedbackDao.delete(feedbackToDelete);
    }
}
