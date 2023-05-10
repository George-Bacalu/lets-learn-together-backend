package com.project.llt.category;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.project.llt.constants.IdentifierConstants.VALID_ID;
import static com.project.llt.mapper.CategoryMapper.convertToDto;
import static com.project.llt.mock.CategoryMock.getMockedCategories;
import static com.project.llt.mock.CategoryMock.getMockedCategory1;
import static com.project.llt.mock.CategoryMock.getMockedCategory2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Spy
    private ModelMapper modelMapper;

    private CategoryDto categoryDto1;
    private CategoryDto categoryDto2;
    private List<CategoryDto> categoryDtos;

    @BeforeEach
    void setUp() {
        categoryDto1 = convertToDto(modelMapper, getMockedCategory1());
        categoryDto2 = convertToDto(modelMapper, getMockedCategory2());
        categoryDtos = getMockedCategories().stream().map(category -> convertToDto(modelMapper, category)).toList();
    }

    @Test
    void getAllCategories_shouldReturnListOfCategories() {
        given(categoryService.getAllCategories()).willReturn(categoryDtos);
        ResponseEntity<List<CategoryDto>> response = categoryController.getAllCategories();
        assertNotNull(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(categoryDtos);
    }

    @Test
    void getCategoryById_shouldReturnCategoryWithGivenId() {
        given(categoryService.getCategoryById(anyLong())).willReturn(categoryDto1);
        ResponseEntity<CategoryDto> response = categoryController.getCategoryById(VALID_ID);
        assertNotNull(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(categoryDto1);
    }

    @Test
    void saveCategory_shouldAddCategoryToList() {
        given(categoryService.saveCategory(any(CategoryDto.class))).willReturn(categoryDto1);
        ResponseEntity<CategoryDto> response = categoryController.saveCategory(categoryDto1);
        assertNotNull(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(categoryDto1);
    }

    @Test
    void updateCategoryById_shouldUpdateCategoryWithGivenId() {
        CategoryDto categoryDto = categoryDto2; categoryDto.setId(VALID_ID);
        given(categoryService.updateCategoryById(any(CategoryDto.class), anyLong())).willReturn(categoryDto);
        ResponseEntity<CategoryDto> response = categoryController.updateCategoryById(categoryDto2, VALID_ID);
        assertNotNull(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(categoryDto);
    }

    @Test
    void deleteCategoryById_shouldRemoveCategoryWithGivenIdFromList() {
        ResponseEntity<Void> response = categoryController.deleteCategoryById(VALID_ID);
        verify(categoryService).deleteCategoryById(VALID_ID);
        assertNotNull(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
