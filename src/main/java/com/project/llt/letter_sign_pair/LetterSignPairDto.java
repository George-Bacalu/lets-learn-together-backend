package com.project.llt.letter_sign_pair;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LetterSignPairDto {

    private Long id;
    private String letter;
    private Integer imageId;
}
