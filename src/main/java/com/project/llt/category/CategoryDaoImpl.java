package com.project.llt.category;

import com.project.llt.section.SectionDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;
    private SectionDao sectionDao;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public CategoryDaoImpl(JdbcTemplate jdbcTemplate, SectionDao sectionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.sectionDao = sectionDao;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("categories").usingGeneratedKeyColumns("id");
    }

    RowMapper<Category> categoryRowMapper = (resultSet, rowNumber) -> Category.builder()
          .id(resultSet.getLong("id"))
          .name(resultSet.getString("name"))
          .imageId(resultSet.getInt("image_id"))
          .isExpanded(resultSet.getBoolean("is_expanded"))
          .isFavorite(resultSet.getBoolean("is_favorite"))
          .parent(findById(resultSet.getObject("parent_id", Long.class)).orElse(null))
          .section(sectionDao.findById(resultSet.getObject("section_id", Long.class)).orElse(null))
          .build();

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT * FROM categories", categoryRowMapper);
    }

    @Override
    public Optional<Category> findById(Long id) {
        try(Stream<Category> stream = jdbcTemplate.queryForStream("SELECT * FROM categories WHERE id = ?", categoryRowMapper, id)) {
            return stream.findFirst();
        }
    }

    @Override
    @Transactional
    public Category save(Category category) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", category.getName());
        parameters.put("image_id", category.getImageId());
        parameters.put("is_expanded", category.getIsExpanded());
        parameters.put("is_favorite", category.getIsFavorite());
        if(category.getParent() != null) parameters.put("parent_id", category.getParent().getId());
        if(category.getSection() != null) parameters.put("section_id", category.getSection().getId());
        Number generatedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        category.setId(generatedId.longValue());
        return category;
    }

    @Override
    @Transactional
    public Category update(Category category) {
        jdbcTemplate.update("UPDATE categories SET name = ?, image_id = ?, is_expanded = ?, is_favorite = ?, parent_id = ?, section_id = ? WHERE id = ?",
              category.getName(),
              category.getImageId(),
              category.getIsExpanded(),
              category.getIsFavorite(),
              category.getParent() != null ? category.getParent().getId() : null,
              category.getSection() != null ? category.getSection().getId() : null,
              category.getId());
        return category;
    }

    @Override
    @Transactional
    public void delete(Category category) {
        jdbcTemplate.update("DELETE FROM categories WHERE id = ?", category.getId());
    }
}
