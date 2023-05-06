package com.project.llt.service;

import com.project.llt.dao.LetterSignPairDao;
import com.project.llt.model.LetterSignPair;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterSignPairServiceImpl implements LetterSignPairService {

    private final LetterSignPairDao letterSignPairDao;

    @Override
    public List<LetterSignPair> getAllLetterSignPairs() {
        return letterSignPairDao.findAll();
    }

    @Override
    public LetterSignPair getLetterSignPairById(Long id) {
        return letterSignPairDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Letter-sign pair with id %s was not found", id)));
    }

    @Override
    public LetterSignPair saveLetterSignPair(LetterSignPair letterSignPair) {
        return letterSignPairDao.save(letterSignPair);
    }

    @Override
    public LetterSignPair updateLetterSignPairById(LetterSignPair letterSignPair, Long id) {
        LetterSignPair letterSignPairToUpdate = getLetterSignPairById(id);
        letterSignPairToUpdate.setLetter(letterSignPair.getLetter());
        letterSignPairToUpdate.setImageId(letterSignPair.getImageId());
        return letterSignPairDao.update(letterSignPairToUpdate);
    }

    @Override
    public void deleteLetterSignPairById(Long id) {
        LetterSignPair letterSignPairToDelete = getLetterSignPairById(id);
        letterSignPairDao.delete(letterSignPairToDelete);
    }
}
