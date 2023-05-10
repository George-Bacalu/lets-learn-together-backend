package com.project.llt.mock;

import com.project.llt.category.Category;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryMock {

    public static List<Category> getMockedCategories() {
        return List.of(getMockedCategory1(), getMockedCategory2());
    }

    public static Category getMockedCategory1() {
        return Category.builder()
              .id(1L)
              .name("test_category_name1")
              .imageId(1)
              .isExpanded(false)
              .isFavorite(false)
              .parent(null)
              .section(null)
              .build();
    }

    public static Category getMockedCategory2() {
        return Category.builder()
              .id(2L)
              .name("test_category_name2")
              .imageId(2)
              .isExpanded(false)
              .isFavorite(false)
              .parent(getMockedCategory1())
              .section(null)
              .build();
    }
}
