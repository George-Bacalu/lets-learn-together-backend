package com.project.llt.notification;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDao notificationDao;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationDao.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Notification with id %s was not found", id)));
    }

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationDao.save(notification);
    }

    @Override
    public Notification updateNotificationById(Notification notification, Long id) {
        Notification notificationToUpdate = getNotificationById(id);
        notificationToUpdate.setMessage(notification.getMessage());
        notificationToUpdate.setIsRead(notification.getIsRead());
        notificationToUpdate.setSentAt(notification.getSentAt());
        notificationToUpdate.setSender(notification.getSender());
        notificationToUpdate.setReceiver(notification.getReceiver());
        return notificationDao.update(notificationToUpdate);
    }

    @Override
    public void deleteNotificationById(Long id) {
        Notification notificationToDelete = getNotificationById(id);
        notificationDao.delete(notificationToDelete);
    }
}
