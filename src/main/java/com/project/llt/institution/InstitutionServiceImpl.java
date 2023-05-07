package com.project.llt.institution;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionDao institutionDao;

    @Override
    public List<InstitutionDto> getAllInstitutions() {
        List<Institution> institutions = institutionDao.findAll();
        return institutions.stream().map(institution -> InstitutionDto.builder()
              .id(institution.getId())
              .school(institution.getSchool())
              .classroom(institution.getClassroom())
              .build()).toList();
    }

    @Override
    public InstitutionDto getInstitutionById(Long id) {
        Institution institution = getInstitutionEntityById(id);
        return InstitutionDto.builder()
              .id(institution.getId())
              .school(institution.getSchool())
              .classroom(institution.getClassroom())
              .build();
    }

    @Override
    public InstitutionDto saveInstitution(InstitutionDto institutionDto) {
        Institution institution = Institution.builder()
              .id(institutionDto.getId())
              .school(institutionDto.getSchool())
              .classroom(institutionDto.getClassroom())
              .build();
        Institution savedInstitution = institutionDao.save(institution);
        return InstitutionDto.builder()
              .id(savedInstitution.getId())
              .school(savedInstitution.getSchool())
              .classroom(savedInstitution.getClassroom())
              .build();
    }

    @Override
    public InstitutionDto updateInstitutionById(InstitutionDto institutionDto, Long id) {
        Institution institutionToUpdate = getInstitutionEntityById(id);
        institutionToUpdate.setSchool(institutionDto.getSchool());
        institutionToUpdate.setClassroom(institutionDto.getClassroom());
        Institution updatedInstitution = institutionDao.update(institutionToUpdate);
        return InstitutionDto.builder()
              .id(updatedInstitution.getId())
              .school(updatedInstitution.getSchool())
              .classroom(updatedInstitution.getClassroom())
              .build();
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
}
