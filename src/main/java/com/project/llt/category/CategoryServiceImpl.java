package com.project.llt.category;

import com.project.llt.section.SectionService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final SectionService sectionService;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryDao.findAll();
        return !categories.isEmpty() ? categories.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = getCategoryEntityById(id);
        return convertToDto(category);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category savedCategory = categoryDao.save(category);
        return convertToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto, Long id) {
        Category categoryToUpdate = getCategoryEntityById(id);
        categoryToUpdate.setName(categoryDto.getName());
        categoryToUpdate.setImageId(categoryDto.getImageId());
        categoryToUpdate.setIsExpanded(categoryDto.getIsExpanded());
        categoryToUpdate.setIsFavorite(categoryDto.getIsFavorite());
        categoryToUpdate.setParent(getCategoryEntityById(categoryDto.getParentId()));
        categoryToUpdate.setSection(sectionService.getSectionEntityById(categoryDto.getSectionId()));
        Category updatedCategory = categoryDao.update(categoryToUpdate);
        return convertToDto(updatedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category categoryToDelete = getCategoryEntityById(id);
        categoryDao.delete(categoryToDelete);
    }

    private Category getCategoryEntityById(Long id) {
        return categoryDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Category with id %s was not found", id)));
    }

    private CategoryDto convertToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category convertToEntity(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setParent(getCategoryEntityById(categoryDto.getParentId()));
        return category;
    }
}
