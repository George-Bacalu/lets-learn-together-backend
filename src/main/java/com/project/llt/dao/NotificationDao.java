package com.project.llt.dao;

import com.project.llt.model.Notification;
import java.util.List;
import java.util.Optional;

public interface NotificationDao {

    List<Notification> findAll();

    Optional<Notification> findById(Long id);

    Notification save(Notification notification);

    Notification update(Notification notification);

    void delete(Notification notification);
}
