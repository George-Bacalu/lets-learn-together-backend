package com.project.llt.dao;

import com.project.llt.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleDao {

    List<Role> findAll();

    Optional<Role> findById(Long id);

    Role save(Role role);

    Role update(Role role);

    void delete(Role role);
}
