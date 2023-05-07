package com.project.llt.category;

import com.project.llt.section.SectionService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.project.llt.constants.ExceptionMessageConstants.CATEGORY_NOT_FOUND;
import static com.project.llt.mapper.CategoryMapper.convertToDto;
import static com.project.llt.mapper.CategoryMapper.convertToEntity;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final SectionService sectionService;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryDao.findAll();
        return !categories.isEmpty() ? categories.stream().map(category -> convertToDto(modelMapper, category)).toList() : new ArrayList<>();
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = getCategoryEntityById(id);
        return convertToDto(modelMapper, category);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = convertToEntity(modelMapper, categoryDto, categoryDao);
        Category savedCategory = categoryDao.save(category);
        return convertToDto(modelMapper, savedCategory);
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
        return convertToDto(modelMapper, updatedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category categoryToDelete = getCategoryEntityById(id);
        categoryDao.delete(categoryToDelete);
    }

    private Category getCategoryEntityById(Long id) {
        return categoryDao.findById(id).orElseThrow(() -> new RuntimeException(String.format(CATEGORY_NOT_FOUND, id)));
    }
}
