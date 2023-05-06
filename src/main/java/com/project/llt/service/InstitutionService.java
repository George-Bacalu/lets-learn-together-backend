package com.project.llt.service;

import com.project.llt.model.Institution;
import java.util.List;

public interface InstitutionService {

    List<Institution> getAllInstitutions();

    Institution getInstitutionById(Long id);

    Institution saveInstitution(Institution institution);

    Institution updateInstitutionById(Institution institution, Long id);

    void deleteInstitutionById(Long id);
}
