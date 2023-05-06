package com.project.llt.notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    Notification saveNotification(Notification notification);

    Notification updateNotificationById(Notification notification, Long id);

    void deleteNotificationById(Long id);
}
