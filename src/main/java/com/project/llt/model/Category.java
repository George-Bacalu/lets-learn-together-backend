package com.project.llt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    private Long id;
    private String name;
    private Integer imageId;
    private Boolean isExpanded;
    private Boolean isFavorite;
    private Category parent;
    private Section section;
}
