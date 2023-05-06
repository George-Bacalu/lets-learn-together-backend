package com.project.llt.letter_sign_pair;

import java.util.List;

public interface LetterSignPairService {

    List<LetterSignPair> getAllLetterSignPairs();

    LetterSignPair getLetterSignPairById(Long id);

    LetterSignPair saveLetterSignPair(LetterSignPair letterSignPair);

    LetterSignPair updateLetterSignPairById(LetterSignPair letterSignPair, Long id);

    void deleteLetterSignPairById(Long id);
}
