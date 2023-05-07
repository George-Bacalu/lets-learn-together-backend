package com.project.llt.institution;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionDao institutionDao;
    private final ModelMapper modelMapper;

    @Override
    public List<InstitutionDto> getAllInstitutions() {
        List<Institution> institutions = institutionDao.findAll();
        return !institutions.isEmpty() ? institutions.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public InstitutionDto getInstitutionById(Long id) {
        Institution institution = getInstitutionEntityById(id);
        return convertToDto(institution);
    }

    @Override
    public InstitutionDto saveInstitution(InstitutionDto institutionDto) {
        Institution institution = convertToEntity(institutionDto);
        Institution savedInstitution = institutionDao.save(institution);
        return convertToDto(savedInstitution);
    }

    @Override
    public InstitutionDto updateInstitutionById(InstitutionDto institutionDto, Long id) {
        Institution institutionToUpdate = getInstitutionEntityById(id);
        institutionToUpdate.setSchool(institutionDto.getSchool());
        institutionToUpdate.setClassroom(institutionDto.getClassroom());
        Institution updatedInstitution = institutionDao.update(institutionToUpdate);
        return convertToDto(updatedInstitution);
    }

    @Override
    public void deleteInstitutionById(Long id) {
        Institution institutionToDelete = getInstitutionEntityById(id);
        institutionDao.delete(institutionToDelete);
    }

    @Override
    public Institution getInstitutionEntityById(Long id) {
        return institutionDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Institution with id %s was not found", id)));
    }

    private InstitutionDto convertToDto(Institution institution) {
        return modelMapper.map(institution, InstitutionDto.class);
    }

    private Institution convertToEntity(InstitutionDto institutionDto) {
        return modelMapper.map(institutionDto, Institution.class);
    }
}
