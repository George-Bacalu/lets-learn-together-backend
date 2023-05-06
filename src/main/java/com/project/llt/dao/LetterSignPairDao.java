package com.project.llt.dao;

import com.project.llt.model.LetterSignPair;
import java.util.List;
import java.util.Optional;

public interface LetterSignPairDao {

    List<LetterSignPair> findAll();

    Optional<LetterSignPair> findById(Long id);

    LetterSignPair save(LetterSignPair letterSignPair);

    LetterSignPair update(LetterSignPair letterSignPair);

    void delete(LetterSignPair letterSignPair);
}
