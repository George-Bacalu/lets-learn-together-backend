package com.project.llt.dao;

import com.project.llt.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    Category update(Category category);

    void delete(Category category);
}
