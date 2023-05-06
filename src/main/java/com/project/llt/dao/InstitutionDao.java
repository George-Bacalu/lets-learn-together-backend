package com.project.llt.dao;

import com.project.llt.model.Institution;
import java.util.List;
import java.util.Optional;

public interface InstitutionDao {

    List<Institution> findAll();

    Optional<Institution> findById(Long id);

    Institution save(Institution institution);

    Institution update(Institution institution);

    void delete(Institution institution);
}
