package com.project.llt.letter_sign_pair;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterSignPairServiceImpl implements LetterSignPairService {

    private final LetterSignPairDao letterSignPairDao;
    private final ModelMapper modelMapper;

    @Override
    public List<LetterSignPairDto> getAllLetterSignPairs() {
        List<LetterSignPair> letterSignPairs = letterSignPairDao.findAll();
        return !letterSignPairs.isEmpty() ? letterSignPairs.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public LetterSignPairDto getLetterSignPairById(Long id) {
        LetterSignPair letterSignPair = getLetterSignPairEntityById(id);
        return convertToDto(letterSignPair);
    }

    @Override
    public LetterSignPairDto saveLetterSignPair(LetterSignPairDto letterSignPairDto) {
        LetterSignPair letterSignPair = convertToEntity(letterSignPairDto);
        LetterSignPair savedLetterSignPair = letterSignPairDao.save(letterSignPair);
        return convertToDto(savedLetterSignPair);
    }

    @Override
    public LetterSignPairDto updateLetterSignPairById(LetterSignPairDto letterSignPairDto, Long id) {
        LetterSignPair letterSignPairToUpdate = getLetterSignPairEntityById(id);
        letterSignPairToUpdate.setLetter(letterSignPairDto.getLetter());
        letterSignPairToUpdate.setImageId(letterSignPairDto.getImageId());
        LetterSignPair updatedLetterSignPair = letterSignPairDao.update(letterSignPairToUpdate);
        return convertToDto(updatedLetterSignPair);
    }

    @Override
    public void deleteLetterSignPairById(Long id) {
        LetterSignPair letterSignPairToDelete = getLetterSignPairEntityById(id);
        letterSignPairDao.delete(letterSignPairToDelete);
    }

    private LetterSignPair getLetterSignPairEntityById(Long id) {
        return letterSignPairDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Letter-sign pair with id %s was not found", id)));
    }

    private LetterSignPairDto convertToDto(LetterSignPair letterSignPair) {
        return modelMapper.map(letterSignPair, LetterSignPairDto.class);
    }

    private LetterSignPair convertToEntity(LetterSignPairDto letterSignPairDto) {
        return modelMapper.map(letterSignPairDto, LetterSignPair.class);
    }
}
