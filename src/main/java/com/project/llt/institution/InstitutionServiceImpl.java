package com.project.llt.institution;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionDao institutionDao;

    @Override
    public List<Institution> getAllInstitutions() {
        return institutionDao.findAll();
    }

    @Override
    public Institution getInstitutionById(Long id) {
        return institutionDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Institution with id %s was not found", id)));
    }

    @Override
    public Institution saveInstitution(Institution institution) {
        return institutionDao.save(institution);
    }

    @Override
    public Institution updateInstitutionById(Institution institution, Long id) {
        Institution institutionToUpdate = getInstitutionById(id);
        institutionToUpdate.setSchool(institution.getSchool());
        institutionToUpdate.setClassroom(institution.getClassroom());
        return institutionDao.update(institutionToUpdate);
    }

    @Override
    public void deleteInstitutionById(Long id) {
        Institution institutionToDelete = getInstitutionById(id);
        institutionDao.delete(institutionToDelete);
    }
}
