package com.project.llt.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private Long id;
    private String name;
    private Integer imageId;
    private Boolean isExpanded = false;
    private Boolean isFavorite = false;
    private Long parentId = null;
    private Long sectionId;
}
