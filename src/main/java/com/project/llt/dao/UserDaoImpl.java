package com.project.llt.dao;

import com.project.llt.model.User;
import java.time.LocalDate;
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
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;
    private InstitutionDao institutionDao;
    private RoleDao roleDao;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public UserDaoImpl(JdbcTemplate jdbcTemplate, InstitutionDao institutionDao, RoleDao roleDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.institutionDao = institutionDao;
        this.roleDao = roleDao;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
    }

    RowMapper<User> userRowMapper = (resultSet, rowNumber) -> User.builder()
          .id(resultSet.getLong("id"))
          .name(resultSet.getString("name"))
          .email(resultSet.getString("email"))
          .password(resultSet.getString("password"))
          .mobile(resultSet.getString("mobile"))
          .address(resultSet.getString("address"))
          .birthday(resultSet.getObject("birthday", LocalDate.class))
          .institution(institutionDao.findById(resultSet.getObject("institution_id", Long.class)).orElse(null))
          .role(roleDao.findById(resultSet.getObject("role_id", Long.class)).orElse(null))
          .build();

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", userRowMapper);
    }

    @Override
    public Optional<User> findById(Long id) {
        try(Stream<User> stream = jdbcTemplate.queryForStream("SELECT * FROM users WHERE id = ?", userRowMapper, id)) {
            return stream.findFirst();
        }
    }

    @Override
    @Transactional
    public User save(User user) {
        Number generatedId = simpleJdbcInsert.executeAndReturnKey(Map.ofEntries(
              Map.entry("name", user.getName()),
              Map.entry("email", user.getEmail()),
              Map.entry("password", user.getPassword()),
              Map.entry("mobile", user.getMobile()),
              Map.entry("address", user.getAddress()),
              Map.entry("birthday", user.getBirthday()),
              Map.entry("institution_id", user.getInstitution() != null ? user.getInstitution().getId() : Optional.empty()),
              Map.entry("role_id", user.getRole() != null ? user.getRole().getId() : Optional.empty())));
        user.setId(generatedId.longValue());
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        jdbcTemplate.update("UPDATE users SET name = ?, email = ?, password = ?, mobile = ?, address = ?, birthday = ?, institution_id = ?, role_id = ? WHERE id = ?",
              user.getName(),
              user.getEmail(),
              user.getPassword(),
              user.getMobile(),
              user.getAddress(),
              user.getBirthday(),
              user.getInstitution() != null ? user.getInstitution().getId() : null,
              user.getRole() != null ? user.getRole().getId() : null,
              user.getId());
        return user;
    }

    @Override
    @Transactional
    public void delete(User user) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", user.getId());
    }
}
