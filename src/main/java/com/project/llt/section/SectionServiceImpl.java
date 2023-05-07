package com.project.llt.section;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionDao sectionDao;

    @Override
    public List<SectionDto> getAllSections() {
        List<Section> sections = sectionDao.findAll();
        return sections.stream().map(section -> SectionDto.builder()
              .id(section.getId())
              .name(section.getName())
              .iconId(section.getIconId())
              .imageId(section.getImageId())
              .build()).toList();
    }

    @Override
    public SectionDto getSectionById(Long id) {
        Section section = getSectionEntityById(id);
        return SectionDto.builder()
              .id(section.getId())
              .name(section.getName())
              .iconId(section.getIconId())
              .imageId(section.getImageId())
              .build();
    }

    @Override
    public SectionDto saveSection(SectionDto sectionDto) {
        Section section = Section.builder()
              .id(sectionDto.getId())
              .name(sectionDto.getName())
              .iconId(sectionDto.getIconId())
              .imageId(sectionDto.getImageId())
              .build();
        Section savedSection = sectionDao.save(section);
        return SectionDto.builder()
              .id(savedSection.getId())
              .name(savedSection.getName())
              .iconId(savedSection.getIconId())
              .imageId(savedSection.getImageId())
              .build();
    }

    @Override
    public SectionDto updateSectionById(SectionDto sectionDto, Long id) {
        Section sectionToUpdate = getSectionEntityById(id);
        sectionToUpdate.setName(sectionDto.getName());
        sectionToUpdate.setIconId(sectionDto.getIconId());
        sectionToUpdate.setImageId(sectionDto.getImageId());
        Section updatedSection = sectionDao.update(sectionToUpdate);
        return SectionDto.builder()
              .id(updatedSection.getId())
              .name(updatedSection.getName())
              .iconId(updatedSection.getIconId())
              .imageId(updatedSection.getImageId())
              .build();
    }

    @Override
    public void deleteSectionById(Long id) {
        Section sectionToDelete = getSectionEntityById(id);
        sectionDao.delete(sectionToDelete);
    }

    @Override
    public Section getSectionEntityById(Long id) {
        return sectionDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Section with id %s was not found", id)));
    }
}
