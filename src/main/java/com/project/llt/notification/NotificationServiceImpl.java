package com.project.llt.notification;

import com.project.llt.user.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDao notificationDao;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public List<NotificationDto> getAllNotifications() {
        List<Notification> notifications = notificationDao.findAll();
        return !notifications.isEmpty() ? notifications.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        Notification notification = getNotificationEntityById(id);
        return convertToDto(notification);
    }

    @Override
    public NotificationDto saveNotification(NotificationDto notificationDto) {
        Notification notification = convertToEntity(notificationDto);
        notification.setSentAt(LocalDateTime.now());
        Notification savedNotification = notificationDao.save(notification);
        return convertToDto(savedNotification);
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
        return convertToDto(updatedNotification);
    }

    @Override
    public void deleteNotificationById(Long id) {
        Notification notificationToDelete = getNotificationEntityById(id);
        notificationDao.delete(notificationToDelete);
    }

    private Notification getNotificationEntityById(Long id) {
        return notificationDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Notification with id %s was not found", id)));
    }

    private NotificationDto convertToDto(Notification notification) {
        return modelMapper.map(notification, NotificationDto.class);
    }

    private Notification convertToEntity(NotificationDto notificationDto) {
        return modelMapper.map(notificationDto, Notification.class);
    }
}
