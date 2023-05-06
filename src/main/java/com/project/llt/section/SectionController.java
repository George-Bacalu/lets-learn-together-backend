package com.project.llt.section;

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
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections() {
        return ResponseEntity.ok(sectionService.getAllSections());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable Long id) {
        return ResponseEntity.ok(sectionService.getSectionById(id));
    }

    @PostMapping
    public ResponseEntity<Section> saveSection(@RequestBody Section section) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionService.saveSection(section));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Section> updateSectionById(@RequestBody Section section, @PathVariable Long id) {
        return ResponseEntity.ok(sectionService.updateSectionById(section, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSectionById(@PathVariable Long id) {
        sectionService.deleteSectionById(id);
        return ResponseEntity.noContent().build();
    }
}
