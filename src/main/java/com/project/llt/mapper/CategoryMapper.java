package com.project.llt.mapper;

import com.project.llt.category.Category;
import com.project.llt.category.CategoryDao;
import com.project.llt.category.CategoryDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryMapper {

    public static CategoryDto convertToDto(ModelMapper modelMapper, Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    public static Category convertToEntity(ModelMapper modelMapper, CategoryDto categoryDto, CategoryDao categoryDao) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setParent(categoryDao.findById(categoryDto.getParentId()).orElse(null));
        return category;
    }
}
