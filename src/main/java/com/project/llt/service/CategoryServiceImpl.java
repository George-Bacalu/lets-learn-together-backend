package com.project.llt.service;

import com.project.llt.dao.CategoryDao;
import com.project.llt.model.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Category with id %s was not found", id)));
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category updateCategoryById(Category category, Long id) {
        Category categoryToUpdate = getCategoryById(id);
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setImageId(category.getImageId());
        categoryToUpdate.setIsExpanded(category.getIsExpanded());
        categoryToUpdate.setIsFavorite(category.getIsFavorite());
        categoryToUpdate.setParent(category.getParent());
        categoryToUpdate.setSection(category.getSection());
        return categoryDao.update(categoryToUpdate);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category categoryToDelete = getCategoryById(id);
        categoryDao.delete(categoryToDelete);
    }
}
