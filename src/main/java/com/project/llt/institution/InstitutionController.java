package com.project.llt.institution;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/institutions")
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping
    public ResponseEntity<List<InstitutionDto>> getAllInstitutions() {
        return ResponseEntity.ok(institutionService.getAllInstitutions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitutionDto> getInstitutionById(@PathVariable Long id) {
        return ResponseEntity.ok(institutionService.getInstitutionById(id));
    }

    @PostMapping
    public ResponseEntity<InstitutionDto> saveInstitution(@RequestBody @Valid InstitutionDto institutionDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionService.saveInstitution(institutionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstitutionDto> updateInstitutionById(@RequestBody @Valid InstitutionDto institutionDto, @PathVariable Long id) {
        return ResponseEntity.ok(institutionService.updateInstitutionById(institutionDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitutionById(@PathVariable Long id) {
        institutionService.deleteInstitutionById(id);
        return ResponseEntity.noContent().build();
    }
}
