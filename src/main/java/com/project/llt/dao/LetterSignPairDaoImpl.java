package com.project.llt.dao;

import com.project.llt.model.LetterSignPair;
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
public class LetterSignPairDaoImpl implements LetterSignPairDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public LetterSignPairDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("letter_sign_pairs").usingGeneratedKeyColumns("id");
    }

    RowMapper<LetterSignPair> letterSignPairRowMapper = (resultSet, rowNumber) -> LetterSignPair.builder()
          .id(resultSet.getLong("id"))
          .letter(resultSet.getString("letter"))
          .imageId(resultSet.getInt("image_id"))
          .build();

    @Override
    public List<LetterSignPair> findAll() {
        return jdbcTemplate.query("SELECT * FROM letter_sign_pairs", letterSignPairRowMapper);
    }

    @Override
    public Optional<LetterSignPair> findById(Long id) {
        try(Stream<LetterSignPair> stream = jdbcTemplate.queryForStream("SELECT * FROM letter_sign_pairs WHERE id = ?", letterSignPairRowMapper, id)) {
            return stream.findFirst();
        }
    }

    @Override
    @Transactional
    public LetterSignPair save(LetterSignPair letterSignPair) {
        Number generatedId = simpleJdbcInsert.executeAndReturnKey(Map.ofEntries(
              Map.entry("letter", letterSignPair.getLetter()),
              Map.entry("image_id", letterSignPair.getImageId())));
        letterSignPair.setId(generatedId.longValue());
        return letterSignPair;
    }

    @Override
    @Transactional
    public LetterSignPair update(LetterSignPair letterSignPair) {
        jdbcTemplate.update("UPDATE letter_sign_pairs SET letter = ?, image_id = ? WHERE id = ?", letterSignPair.getLetter(), letterSignPair.getImageId(), letterSignPair.getId());
        return letterSignPair;
    }

    @Override
    @Transactional
    public void delete(LetterSignPair letterSignPair) {
        jdbcTemplate.update("DELETE FROM letter_sign_pairs WHERE id = ?", letterSignPair.getId());
    }
}
