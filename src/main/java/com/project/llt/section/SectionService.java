package com.project.llt.section;

import java.util.List;

public interface SectionService {

    List<Section> getAllSections();

    Section getSectionById(Long id);

    Section saveSection(Section section);

    Section updateSectionById(Section section, Long id);

    void deleteSectionById(Long id);
}
