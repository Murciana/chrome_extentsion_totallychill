package com.mlb.apiProjectTC.service;

import com.mlb.apiProjectTC.model.PhrasesDTO;

import java.util.List;
import java.util.Optional;

public interface PhrasesService {
    List<PhrasesDTO> getAllPhrases();
    Optional<PhrasesDTO> getPhrasesById(Long id);
    PhrasesDTO savePhrases(PhrasesDTO phrasesDTO);
    PhrasesDTO updatePhrases(Long id, PhrasesDTO phrasesDTO);
    void deletePhrases(Long id);
}
