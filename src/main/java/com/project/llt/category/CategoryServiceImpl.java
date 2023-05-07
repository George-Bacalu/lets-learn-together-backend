package com.project.llt.category;

import com.project.llt.section.SectionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final SectionService sectionService;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryDao.findAll();
        return categories.stream().map(category -> CategoryDto.builder()
              .id(category.getId())
              .name(category.getName())
              .imageId(category.getImageId())
              .isExpanded(category.getIsExpanded())
              .isFavorite(category.getIsFavorite())
              .parentId(category.getParent().getId())
              .sectionId(category.getSection().getId())
              .build()).toList();
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = getCategoryEntityById(id);
        return CategoryDto.builder()
              .id(category.getId())
              .name(category.getName())
              .imageId(category.getImageId())
              .isExpanded(category.getIsExpanded())
              .isFavorite(category.getIsFavorite())
              .parentId(category.getParent().getId())
              .sectionId(category.getSection().getId())
              .build();
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = Category.builder()
              .id(categoryDto.getId())
              .name(categoryDto.getName())
              .imageId(categoryDto.getImageId())
              .isExpanded(categoryDto.getIsExpanded())
              .isFavorite(categoryDto.getIsFavorite())
              .parent(categoryDao.findById(categoryDto.getParentId()).orElse(null))
              .section(sectionService.getSectionEntityById(categoryDto.getSectionId()))
              .build();
        Category savedCategory = categoryDao.save(category);
        return CategoryDto.builder()
              .id(savedCategory.getId())
              .name(savedCategory.getName())
              .imageId(savedCategory.getImageId())
              .isExpanded(savedCategory.getIsExpanded())
              .isFavorite(savedCategory.getIsFavorite())
              .parentId(savedCategory.getParent() != null ? savedCategory.getParent().getId() : null)
              .sectionId(savedCategory.getSection().getId())
              .build();
    }

    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto, Long id) {
        Category categoryToUpdate = getCategoryEntityById(id);
        categoryToUpdate.setName(categoryDto.getName());
        categoryToUpdate.setImageId(categoryDto.getImageId());
        categoryToUpdate.setIsExpanded(categoryDto.getIsExpanded());
        categoryToUpdate.setIsFavorite(categoryDto.getIsFavorite());
        categoryToUpdate.setParent(categoryDao.findById(categoryDto.getParentId()).orElse(null));
        categoryToUpdate.setSection(sectionService.getSectionEntityById(categoryDto.getSectionId()));
        Category updatedCategory = categoryDao.update(categoryToUpdate);
        return CategoryDto.builder()
              .id(updatedCategory.getId())
              .name(updatedCategory.getName())
              .imageId(updatedCategory.getImageId())
              .isExpanded(updatedCategory.getIsExpanded())
              .isFavorite(updatedCategory.getIsFavorite())
              .parentId(updatedCategory.getParent().getId())
              .sectionId(updatedCategory.getSection().getId())
              .build();
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category categoryToDelete = getCategoryEntityById(id);
        categoryDao.delete(categoryToDelete);
    }

    private Category getCategoryEntityById(Long id) {
        return categoryDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Category with id %s was not found", id)));
    }
}
