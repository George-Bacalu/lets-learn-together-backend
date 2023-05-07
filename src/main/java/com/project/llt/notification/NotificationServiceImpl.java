package com.project.llt.notification;

import com.project.llt.user.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.project.llt.mapper.NotificationMapper.convertToDto;
import static com.project.llt.mapper.NotificationMapper.convertToEntity;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDao notificationDao;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public List<NotificationDto> getAllNotifications() {
        List<Notification> notifications = notificationDao.findAll();
        return !notifications.isEmpty() ? notifications.stream().map(notification -> convertToDto(modelMapper, notification)).toList() : new ArrayList<>();
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        Notification notification = getNotificationEntityById(id);
        return convertToDto(modelMapper, notification);
    }

    @Override
    public NotificationDto saveNotification(NotificationDto notificationDto) {
        Notification notification = convertToEntity(modelMapper, notificationDto);
        notification.setSentAt(LocalDateTime.now());
        Notification savedNotification = notificationDao.save(notification);
        return convertToDto(modelMapper, savedNotification);
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
        updatedNotification.setSentAt(LocalDateTime.now());
        return convertToDto(modelMapper, updatedNotification);
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
