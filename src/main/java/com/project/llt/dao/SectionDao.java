package com.project.llt.dao;

import com.project.llt.model.Section;
import java.util.List;
import java.util.Optional;

public interface SectionDao {

    List<Section> findAll();

    Optional<Section> findById(Long id);

    Section save(Section section);

    Section update(Section section);

    void delete(Section section);
}
