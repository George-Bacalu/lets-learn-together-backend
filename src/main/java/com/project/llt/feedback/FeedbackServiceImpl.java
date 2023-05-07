package com.project.llt.feedback;

import com.project.llt.user.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDao feedbackDao;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public List<FeedbackDto> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackDao.findAll();
        return !feedbacks.isEmpty() ? feedbacks.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public FeedbackDto getFeedbackById(Long id) {
        Feedback feedback = getFeedbackEntityById(id);
        return convertToDto(feedback);
    }

    @Override
    public FeedbackDto saveFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = convertToEntity(feedbackDto);
        feedback.setSentAt(LocalDateTime.now());
        Feedback savedFeedback = feedbackDao.save(feedback);
        return convertToDto(savedFeedback);
    }

    @Override
    public FeedbackDto updateFeedbackById(FeedbackDto feedbackDto, Long id) {
        Feedback feedbackToUpdate = getFeedbackEntityById(id);
        feedbackToUpdate.setType(feedbackDto.getType());
        feedbackToUpdate.setDescription(feedbackDto.getDescription());
        feedbackToUpdate.setSentAt(feedbackDto.getSentAt());
        feedbackToUpdate.setUser(userService.getUserEntityById(feedbackDto.getUserId()));
        Feedback updatedFeedback = feedbackDao.update(feedbackToUpdate);
        return convertToDto(updatedFeedback);
    }

    @Override
    public void deleteFeedbackById(Long id) {
        Feedback feedbackToDelete = getFeedbackEntityById(id);
        feedbackDao.delete(feedbackToDelete);
    }

    private Feedback getFeedbackEntityById(Long id) {
        return feedbackDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Feedback with id %s was not found", id)));
    }

    private FeedbackDto convertToDto(Feedback feedback) {
        return modelMapper.map(feedback, FeedbackDto.class);
    }

    private Feedback convertToEntity(FeedbackDto feedbackDto) {
        return modelMapper.map(feedbackDto, Feedback.class);
    }
}
