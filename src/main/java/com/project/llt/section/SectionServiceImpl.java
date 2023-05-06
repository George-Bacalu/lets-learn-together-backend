package com.project.llt.section;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionDao sectionDao;

    @Override
    public List<Section> getAllSections() {
        return sectionDao.findAll();
    }

    @Override
    public Section getSectionById(Long id) {
        return sectionDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Section with id %s was not found", id)));
    }

    @Override
    public Section saveSection(Section section) {
        return sectionDao.save(section);
    }

    @Override
    public Section updateSectionById(Section section, Long id) {
        Section sectionToUpdate = getSectionById(id);
        sectionToUpdate.setName(section.getName());
        sectionToUpdate.setIconId(section.getIconId());
        sectionToUpdate.setImageId(section.getImageId());
        return sectionDao.update(sectionToUpdate);
    }

    @Override
    public void deleteSectionById(Long id) {
        Section sectionToDelete = getSectionById(id);
        sectionDao.delete(sectionToDelete);
    }
}
