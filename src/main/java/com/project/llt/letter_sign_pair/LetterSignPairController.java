package com.project.llt.letter_sign_pair;

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
@RequestMapping("/api/letter-sign-pairs")
public class LetterSignPairController {

    private final LetterSignPairService letterSignPairService;

    @GetMapping
    public ResponseEntity<List<LetterSignPairDto>> getAllLetterSignPairs() {
        return ResponseEntity.ok(letterSignPairService.getAllLetterSignPairs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetterSignPairDto> getLetterSignPairById(@PathVariable Long id) {
        return ResponseEntity.ok(letterSignPairService.getLetterSignPairById(id));
    }

    @PostMapping
    public ResponseEntity<LetterSignPairDto> saveLetterSignPair(@RequestBody @Valid LetterSignPairDto letterSignPairDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(letterSignPairService.saveLetterSignPair(letterSignPairDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LetterSignPairDto> updateLetterSignPairById(@RequestBody @Valid LetterSignPairDto letterSignPairDto, @PathVariable Long id) {
        return ResponseEntity.ok(letterSignPairService.updateLetterSignPairById(letterSignPairDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLetterSignPairById(@PathVariable Long id) {
        letterSignPairService.deleteLetterSignPairById(id);
        return ResponseEntity.noContent().build();
    }
}
