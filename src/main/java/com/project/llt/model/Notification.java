package com.project.llt.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {

    private Long id;
    private String message;
    private User sender;
    private User receiver;
    private Boolean isRead;
    private LocalDateTime sentAt;
}
