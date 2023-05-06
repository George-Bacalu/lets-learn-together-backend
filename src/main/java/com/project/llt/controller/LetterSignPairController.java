package com.project.llt.controller;

import com.project.llt.model.LetterSignPair;
import com.project.llt.service.LetterSignPairService;
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
@RequestMapping("/api/letter-sign-pairs")
public class LetterSignPairController {

    private final LetterSignPairService letterSignPairService;

    @GetMapping
    public ResponseEntity<List<LetterSignPair>> getAllLetterSignPairs() {
        return ResponseEntity.ok(letterSignPairService.getAllLetterSignPairs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetterSignPair> getLetterSignPairById(@PathVariable Long id) {
        return ResponseEntity.ok(letterSignPairService.getLetterSignPairById(id));
    }

    @PostMapping
    public ResponseEntity<LetterSignPair> saveLetterSignPair(@RequestBody LetterSignPair letterSignPair) {
        return ResponseEntity.status(HttpStatus.CREATED).body(letterSignPairService.saveLetterSignPair(letterSignPair));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LetterSignPair> updateLetterSignPairById(@RequestBody LetterSignPair letterSignPair, @PathVariable Long id) {
        return ResponseEntity.ok(letterSignPairService.updateLetterSignPairById(letterSignPair, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLetterSignPairById(@PathVariable Long id) {
        letterSignPairService.deleteLetterSignPairById(id);
        return ResponseEntity.noContent().build();
    }
}
