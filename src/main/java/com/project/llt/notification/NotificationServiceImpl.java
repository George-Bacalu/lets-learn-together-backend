package com.project.llt.notification;

import com.project.llt.user.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDao notificationDao;
    private final UserService userService;

    @Override
    public List<NotificationDto> getAllNotifications() {
        List<Notification> notifications = notificationDao.findAll();
        return notifications.stream().map(notification -> NotificationDto.builder()
              .id(notification.getId())
              .message(notification.getMessage())
              .isRead(notification.getIsRead())
              .sentAt(notification.getSentAt())
              .senderId(notification.getSender().getId())
              .receiverId(notification.getReceiver().getId())
              .build()).toList();
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        Notification notification = getNotificationEntityById(id);
        return NotificationDto.builder()
              .id(notification.getId())
              .message(notification.getMessage())
              .isRead(notification.getIsRead())
              .sentAt(notification.getSentAt())
              .senderId(notification.getSender().getId())
              .receiverId(notification.getReceiver().getId())
              .build();
    }

    @Override
    public NotificationDto saveNotification(NotificationDto notificationDto) {
        Notification notification = Notification.builder()
              .id(notificationDto.getId())
              .message(notificationDto.getMessage())
              .isRead(notificationDto.getIsRead())
              .sentAt(notificationDto.getSentAt())
              .sender(userService.getUserEntityById(notificationDto.getSenderId()))
              .receiver(userService.getUserEntityById(notificationDto.getReceiverId()))
              .build();
        Notification savedNotification = notificationDao.save(notification);
        return NotificationDto.builder()
              .id(savedNotification.getId())
              .message(savedNotification.getMessage())
              .isRead(savedNotification.getIsRead())
              .sentAt(savedNotification.getSentAt())
              .senderId(savedNotification.getSender().getId())
              .receiverId(savedNotification.getReceiver().getId())
              .build();
    }

    @Override
    public NotificationDto updateNotificationById(NotificationDto notificationDto, Long id) {
        Notification notificationToUpdate = getNotificationEntityById(id);
        notificationToUpdate.setMessage(notificationDto.getMessage());
        notificationToUpdate.setIsRead(notificationDto.getIsRead());
        notificationToUpdate.setSentAt(notificationDto.getSentAt());
        notificationToUpdate.setSender(userService.getUserEntityById(notificationDto.getSenderId()));
        notificationToUpdate.setReceiver(userService.getUserEntityById(notificationDto.getReceiverId()));
        Notification updatedNotification = notificationDao.update(notificationToUpdate);
        return NotificationDto.builder()
              .id(updatedNotification.getId())
              .message(updatedNotification.getMessage())
              .isRead(updatedNotification.getIsRead())
              .sentAt(updatedNotification.getSentAt())
              .senderId(updatedNotification.getSender().getId())
              .receiverId(updatedNotification.getReceiver().getId())
              .build();
    }

    @Override
    public void deleteNotificationById(Long id) {
        Notification notificationToDelete = getNotificationEntityById(id);
        notificationDao.delete(notificationToDelete);
    }

    private Notification getNotificationEntityById(Long id) {
        return notificationDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Notification with id %s was not found", id)));
    }
}
