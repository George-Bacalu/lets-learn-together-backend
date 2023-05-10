package com.project.llt.category;

import com.project.llt.exception.ResourceNotFoundException;
import com.project.llt.section.SectionService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static com.project.llt.constants.ExceptionMessageConstants.CATEGORY_NOT_FOUND;
import static com.project.llt.constants.IdentifierConstants.INVALID_ID;
import static com.project.llt.constants.IdentifierConstants.VALID_ID;
import static com.project.llt.mapper.CategoryMapper.convertToDto;
import static com.project.llt.mock.CategoryMock.getMockedCategories;
import static com.project.llt.mock.CategoryMock.getMockedCategory1;
import static com.project.llt.mock.CategoryMock.getMockedCategory2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryDao categoryDao;

    @Mock
    private SectionService sectionService;

    @Spy
    private ModelMapper modelMapper;

    @Captor
    private ArgumentCaptor<Category> categoryCaptor;

    private Category category1;
    private Category category2;
    private List<Category> categories;
    private CategoryDto categoryDto1;
    private CategoryDto categoryDto2;
    private List<CategoryDto> categoryDtos;

    @BeforeEach
    void setUp() {
        category1 = getMockedCategory1();
        category2 = getMockedCategory2();
        categories = getMockedCategories();
        categoryDto1 = convertToDto(modelMapper, category1);
        categoryDto2 = convertToDto(modelMapper, category2);
        categoryDtos = categories.stream().map(category -> convertToDto(modelMapper, category)).toList();
    }

    @Test
    void getAllCategories_shouldReturnListOfCategories() {
        given(categoryDao.findAll()).willReturn(categories);
        List<CategoryDto> result = categoryService.getAllCategories();
        assertThat(result).isEqualTo(categoryDtos);
    }

    @Test
    void getCategoryById_withValidId_shouldReturnCategoryWithGivenId() {
        given(categoryDao.findById(anyLong())).willReturn(Optional.ofNullable(category1));
        CategoryDto result = categoryService.getCategoryById(VALID_ID);
        assertThat(result).isEqualTo(categoryDto1);
    }

    @Test
    void getCategoryById_withInvalidId_shouldThrowException() {
        assertThatThrownBy(() -> categoryService.getCategoryById(INVALID_ID))
              .isInstanceOf(ResourceNotFoundException.class)
              .hasMessage(String.format(CATEGORY_NOT_FOUND, INVALID_ID));
    }

    @Test
    void saveCategory_shouldAddCategoryToList() {
        given(categoryDao.save(any(Category.class))).willReturn(category1);
        CategoryDto result = categoryService.saveCategory(categoryDto1);
        verify(categoryDao).save(categoryCaptor.capture());
        assertThat(result).isEqualTo(convertToDto(modelMapper, categoryCaptor.getValue()));
    }

    @Test
    void updateCategoryById_withValidId_shouldUpdateCategoryWithGivenId() {
        Category category = category2; category.setId(VALID_ID);
        given(categoryDao.findById(anyLong())).willReturn(Optional.ofNullable(category1));
        given(categoryDao.update(any(Category.class))).willReturn(category);
        CategoryDto result = categoryService.updateCategoryById(categoryDto2, VALID_ID);
        verify(categoryDao).update(categoryCaptor.capture());
        assertThat(result).isEqualTo(convertToDto(modelMapper, categoryCaptor.getValue()));
    }

    @Test
    void updateCategoryById_withInvalidId_shouldThrowException() {
        assertThatThrownBy(() -> categoryService.updateCategoryById(categoryDto2, INVALID_ID))
              .isInstanceOf(ResourceNotFoundException.class)
              .hasMessage(String.format(CATEGORY_NOT_FOUND, INVALID_ID));
        verify(categoryDao, never()).update(any(Category.class));
    }

    @Test
    void deleteCategoryById_withValidId_shouldRemoveCategoryWithGivenIdFromList() {
        given(categoryDao.findById(anyLong())).willReturn(Optional.ofNullable(category1));
        categoryService.deleteCategoryById(VALID_ID);
        verify(categoryDao).delete(category1);
    }

    @Test
    void deleteCategoryById_withInvalidId_shouldThrowException() {
        assertThatThrownBy(() -> categoryService.deleteCategoryById(INVALID_ID))
              .isInstanceOf(ResourceNotFoundException.class)
              .hasMessage(String.format(CATEGORY_NOT_FOUND, INVALID_ID));
        verify(categoryDao, never()).delete(any(Category.class));
    }
}
