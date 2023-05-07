package com.project.llt.feedback;

import com.project.llt.feedback.enums.FeedbackType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackDto {

    private Long id;
    private FeedbackType type;
    private String description;
    private LocalDateTime sentAt;
    private Long userId;
}
