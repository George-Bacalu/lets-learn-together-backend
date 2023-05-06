package com.project.llt.service;

import com.project.llt.model.Notification;
import java.util.List;

public interface NotificationService {

    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    Notification saveNotification(Notification notification);

    Notification updateNotificationById(Notification notification, Long id);

    void deleteNotificationById(Long id);
}
