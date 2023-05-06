package com.project.llt.dao;

import com.project.llt.model.Feedback;
import java.util.List;
import java.util.Optional;

public interface FeedbackDao {

    List<Feedback> findAll();

    Optional<Feedback> findById(Long id);

    Feedback save(Feedback feedback);

    Feedback update(Feedback feedback);

    void delete(Feedback feedback);
}
