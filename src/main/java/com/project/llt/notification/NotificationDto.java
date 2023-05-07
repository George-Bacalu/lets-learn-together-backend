package com.project.llt.notification;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDto {

    private Long id;
    private String message;
    private Long senderId;
    private Long receiverId;
    private Boolean isRead;
    private LocalDateTime sentAt;
}
