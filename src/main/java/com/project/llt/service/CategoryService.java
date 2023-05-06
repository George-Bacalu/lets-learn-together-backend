package com.project.llt.service;

import com.project.llt.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category saveCategory(Category category);

    Category updateCategoryById(Category category, Long id);

    void deleteCategoryById(Long id);
}
