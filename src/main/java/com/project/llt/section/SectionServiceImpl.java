package com.project.llt.section;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionDao sectionDao;
    private final ModelMapper modelMapper;

    @Override
    public List<SectionDto> getAllSections() {
        List<Section> sections = sectionDao.findAll();
        return !sections.isEmpty() ?  sections.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public SectionDto getSectionById(Long id) {
        Section section = getSectionEntityById(id);
        return convertToDto(section);
    }

    @Override
    public SectionDto saveSection(SectionDto sectionDto) {
        Section section = convertToEntity(sectionDto);
        Section savedSection = sectionDao.save(section);
        return convertToDto(savedSection);
    }

    @Override
    public SectionDto updateSectionById(SectionDto sectionDto, Long id) {
        Section sectionToUpdate = getSectionEntityById(id);
        sectionToUpdate.setName(sectionDto.getName());
        sectionToUpdate.setIconId(sectionDto.getIconId());
        sectionToUpdate.setImageId(sectionDto.getImageId());
        Section updatedSection = sectionDao.update(sectionToUpdate);
        return convertToDto(updatedSection);
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

    private SectionDto convertToDto(Section section) {
        return modelMapper.map(section, SectionDto.class);
    }

    private Section convertToEntity(SectionDto sectionDto) {
        return modelMapper.map(sectionDto, Section.class);
    }
}
