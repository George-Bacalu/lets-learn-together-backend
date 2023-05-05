package com.project.llt.model;

import com.project.llt.model.enums.FeedbackType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {

    private Long id;
    private FeedbackType type;
    private String description;
    private LocalDateTime sentAt;
    private User user;
}
