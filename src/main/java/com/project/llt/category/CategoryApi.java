package com.project.llt.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface CategoryApi {

    @Operation(summary = "Get all categories", description = "Return a list of categories", tags = {"category"}, responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation"),
          @ApiResponse(responseCode = "404", description = "No categories found"),
          @ApiResponse(responseCode = "500", description = "Internal server error")})
    ResponseEntity<List<CategoryDto>> getAllCategories();

    @Operation(summary = "Get category by ID", description = "Return the category with the given ID", tags = {"category"}, responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation"),
          @ApiResponse(responseCode = "404", description = "Invalid ID supplied"),
          @ApiResponse(responseCode = "500", description = "Internal server error")},
          parameters = @Parameter(name = "id", description = "ID of category to retrieve", example = "1"))
    ResponseEntity<CategoryDto> getCategoryById(Long id);

    @Operation(summary = "Save category", description = "Create a new category", tags = {"category"}, responses = {
          @ApiResponse(responseCode = "201", description = "Successful operation"),
          @ApiResponse(responseCode = "400", description = "Invalid request body"),
          @ApiResponse(responseCode = "500", description = "Internal server error")},
          requestBody = @RequestBody(description = "Category object to save"))
    ResponseEntity<CategoryDto> saveCategory(CategoryDto categoryDto);

    @Operation(summary = "Update category by ID", description = "Update an existing category by ID", tags = {"category"}, responses = {
          @ApiResponse(responseCode = "200", description = "Successful operation"),
          @ApiResponse(responseCode = "400", description = "Invalid request body"),
          @ApiResponse(responseCode = "404", description = "Invalid ID supplied"),
          @ApiResponse(responseCode = "500", description = "Internal server error")},
          requestBody = @RequestBody(description = "Category object to update"),
          parameters = @Parameter(name = "id", description = "ID of category to update", example = "1"))
    ResponseEntity<CategoryDto> updateCategoryById(CategoryDto categoryDto, Long id);

    @Operation(summary = "Delete category by ID", description = "Delete an existing category by ID", tags = {"category"}, responses = {
          @ApiResponse(responseCode = "204", description = "Successful operation"),
          @ApiResponse(responseCode = "404", description = "Invalid ID supplied"),
          @ApiResponse(responseCode = "500", description = "Internal server error")},
          parameters = @Parameter(name = "id", description = "ID of category to delete", example = "1"))
    ResponseEntity<Void> deleteCategoryById(Long id);
}
