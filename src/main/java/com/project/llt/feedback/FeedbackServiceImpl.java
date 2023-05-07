package com.project.llt.feedback;

import com.project.llt.user.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDao feedbackDao;
    private final UserService userService;

    @Override
    public List<FeedbackDto> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackDao.findAll();
        return feedbacks.stream().map(feedback -> FeedbackDto.builder()
              .id(feedback.getId())
              .type(feedback.getType())
              .description(feedback.getDescription())
              .sentAt(feedback.getSentAt())
              .userId(feedback.getUser().getId())
              .build()).toList();
    }

    @Override
    public FeedbackDto getFeedbackById(Long id) {
        Feedback feedback = getFeedbackEntityById(id);
        return FeedbackDto.builder()
              .id(feedback.getId())
              .type(feedback.getType())
              .description(feedback.getDescription())
              .sentAt(feedback.getSentAt())
              .userId(feedback.getUser().getId())
              .build();
    }

    @Override
    public FeedbackDto saveFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = Feedback.builder()
              .id(feedbackDto.getId())
              .type(feedbackDto.getType())
              .description(feedbackDto.getDescription())
              .sentAt(feedbackDto.getSentAt())
              .user(userService.getUserEntityById(feedbackDto.getUserId()))
              .build();
        Feedback savedFeedback = feedbackDao.save(feedback);
        return FeedbackDto.builder()
              .id(savedFeedback.getId())
              .type(savedFeedback.getType())
              .description(savedFeedback.getDescription())
              .sentAt(savedFeedback.getSentAt())
              .userId(savedFeedback.getUser().getId())
              .build();
    }

    @Override
    public FeedbackDto updateFeedbackById(FeedbackDto feedbackDto, Long id) {
        Feedback feedbackToUpdate = getFeedbackEntityById(id);
        feedbackToUpdate.setType(feedbackDto.getType());
        feedbackToUpdate.setDescription(feedbackDto.getDescription());
        feedbackToUpdate.setSentAt(feedbackDto.getSentAt());
        feedbackToUpdate.setUser(userService.getUserEntityById(feedbackDto.getUserId()));
        Feedback updatedFeedback = feedbackDao.update(feedbackToUpdate);
        return FeedbackDto.builder()
              .id(updatedFeedback.getId())
              .type(updatedFeedback.getType())
              .description(updatedFeedback.getDescription())
              .sentAt(updatedFeedback.getSentAt())
              .userId(updatedFeedback.getUser().getId())
              .build();
    }

    @Override
    public void deleteFeedbackById(Long id) {
        Feedback feedbackToDelete = getFeedbackEntityById(id);
        feedbackDao.delete(feedbackToDelete);
    }

    private Feedback getFeedbackEntityById(Long id) {
        return feedbackDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Feedback with id %s was not found", id)));
    }
}
