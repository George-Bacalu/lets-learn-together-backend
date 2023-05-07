package com.project.llt.letter_sign_pair;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterSignPairServiceImpl implements LetterSignPairService {

    private final LetterSignPairDao letterSignPairDao;

    @Override
    public List<LetterSignPairDto> getAllLetterSignPairs() {
        List<LetterSignPair> letterSignPairs = letterSignPairDao.findAll();
        return letterSignPairs.stream().map(letterSignPair -> LetterSignPairDto.builder()
              .id(letterSignPair.getId())
              .letter(letterSignPair.getLetter())
              .imageId(letterSignPair.getImageId())
              .build()).toList();
    }

    @Override
    public LetterSignPairDto getLetterSignPairById(Long id) {
        LetterSignPair letterSignPair = getLetterSignPairEntityById(id);
        return LetterSignPairDto.builder()
              .id(letterSignPair.getId())
              .letter(letterSignPair.getLetter())
              .imageId(letterSignPair.getImageId())
              .build();
    }

    @Override
    public LetterSignPairDto saveLetterSignPair(LetterSignPairDto letterSignPairDto) {
        LetterSignPair letterSignPair = LetterSignPair.builder()
              .id(letterSignPairDto.getId())
              .letter(letterSignPairDto.getLetter())
              .imageId(letterSignPairDto.getImageId())
              .build();
        LetterSignPair savedLetterSignPair = letterSignPairDao.save(letterSignPair);
        return LetterSignPairDto.builder()
              .id(savedLetterSignPair.getId())
              .letter(savedLetterSignPair.getLetter())
              .imageId(savedLetterSignPair.getImageId())
              .build();
    }

    @Override
    public LetterSignPairDto updateLetterSignPairById(LetterSignPairDto letterSignPairDto, Long id) {
        LetterSignPair letterSignPairToUpdate = getLetterSignPairEntityById(id);
        letterSignPairToUpdate.setLetter(letterSignPairDto.getLetter());
        letterSignPairToUpdate.setImageId(letterSignPairDto.getImageId());
        LetterSignPair updatedLetterSignPair = letterSignPairDao.update(letterSignPairToUpdate);
        return LetterSignPairDto.builder()
              .id(updatedLetterSignPair.getId())
              .letter(updatedLetterSignPair.getLetter())
              .imageId(updatedLetterSignPair.getImageId())
              .build();
    }

    @Override
    public void deleteLetterSignPairById(Long id) {
        LetterSignPair letterSignPairToDelete = getLetterSignPairEntityById(id);
        letterSignPairDao.delete(letterSignPairToDelete);
    }

    private LetterSignPair getLetterSignPairEntityById(Long id) {
        return letterSignPairDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Letter-sign pair with id %s was not found", id)));
    }
}
