package com.project.llt.dao;

import com.project.llt.model.Feedback;
import com.project.llt.model.enums.FeedbackType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

    private final JdbcTemplate jdbcTemplate;
    private UserDao userDao;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public FeedbackDaoImpl(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("feedbacks").usingGeneratedKeyColumns("id");
    }

    RowMapper<Feedback> feedbackRowMapper = (resultSet, rowNumber) -> Feedback.builder()
          .id(resultSet.getLong("id"))
          .type(FeedbackType.valueOf(resultSet.getString("type")))
          .description(resultSet.getString("description"))
          .sentAt(resultSet.getObject("sent_at", LocalDateTime.class))
          .user(userDao.findById(resultSet.getObject("user_id", Long.class)).orElse(null))
          .build();

    @Override
    public List<Feedback> findAll() {
        return jdbcTemplate.query("SELECT * FROM feedbacks", feedbackRowMapper);
    }

    @Override
    public Optional<Feedback> findById(Long id) {
        try(Stream<Feedback> stream = jdbcTemplate.queryForStream("SELECT * FROM feedbacks WHERE id = ?", feedbackRowMapper, id)) {
            return stream.findFirst();
        }
    }

    @Override
    @Transactional
    public Feedback save(Feedback feedback) {
        Number generatedId = simpleJdbcInsert.executeAndReturnKey(Map.ofEntries(
              Map.entry("type", feedback.getType()),
              Map.entry("description", feedback.getDescription()),
              Map.entry("sent_at", feedback.getSentAt()),
              Map.entry("user_id", feedback.getUser() != null ? feedback.getUser().getId() : Optional.empty())));
        feedback.setId(generatedId.longValue());
        return feedback;
    }

    @Override
    @Transactional
    public Feedback update(Feedback feedback) {
        jdbcTemplate.update("UPDATE feedbacks SET type = ?, description = ?, sent_at = ?, user_id = ? WHERE id = ?",
              String.valueOf(feedback.getType()),
              feedback.getDescription(),
              feedback.getSentAt(),
              feedback.getUser() != null ? feedback.getUser().getId() : null,
              feedback.getId());
        return feedback;
    }

    @Override
    @Transactional
    public void delete(Feedback feedback) {
        jdbcTemplate.update("DELETE FROM feedbacks WHERE id = ?", feedback.getId());
    }
}
