package com.project.llt.notification;

import com.project.llt.user.UserDao;
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
public class NotificationDaoImpl implements NotificationDao {

    private final JdbcTemplate jdbcTemplate;
    private UserDao userDao;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public NotificationDaoImpl(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("notifications").usingGeneratedKeyColumns("id");
    }

    RowMapper<Notification> notificationRowMapper = (resultSet, rowNumber) -> Notification.builder()
          .id(resultSet.getLong("id"))
          .message(resultSet.getString("message"))
          .isRead(resultSet.getBoolean("is_read"))
          .sentAt(resultSet.getObject("sent_at", LocalDateTime.class))
          .sender(userDao.findById(resultSet.getObject("sender_id", Long.class)).orElse(null))
          .receiver(userDao.findById(resultSet.getObject("receiver_id", Long.class)).orElse(null))
          .build();

    @Override
    public List<Notification> findAll() {
        return jdbcTemplate.query("SELECT * FROM notifications", notificationRowMapper);
    }

    @Override
    public Optional<Notification> findById(Long id) {
        try(Stream<Notification> stream = jdbcTemplate.queryForStream("SELECT * FROM notifications WHERE id = ?", notificationRowMapper, id)) {
            return stream.findFirst();
        }
    }

    @Override
    @Transactional
    public Notification save(Notification notification) {
        Number generatedId = simpleJdbcInsert.executeAndReturnKey(Map.ofEntries(
              Map.entry("message", notification.getMessage()),
              Map.entry("is_read", notification.getIsRead()),
              Map.entry("sent_at", notification.getSentAt()),
              Map.entry("sender_id", notification.getSender() != null ? notification.getSender().getId() : Optional.empty()),
              Map.entry("receiver_id", notification.getReceiver() != null ? notification.getReceiver().getId() : Optional.empty())));
        notification.setId(generatedId.longValue());
        return notification;
    }

    @Override
    @Transactional
    public Notification update(Notification notification) {
        jdbcTemplate.update("UPDATE notifications SET message = ?, is_read = ?, sent_at = ?, sender_id = ?, receiver_id = ? WHERE id = ?",
              notification.getMessage(),
              notification.getIsRead(),
              notification.getSentAt(),
              notification.getSender() != null ? notification.getSender().getId() : null,
              notification.getReceiver() != null ? notification.getReceiver().getId() : null,
              notification.getId());
        return notification;
    }

    @Override
    @Transactional
    public void delete(Notification notification) {
        jdbcTemplate.update("DELETE FROM notifications WHERE id = ?", notification.getId());
    }
}
