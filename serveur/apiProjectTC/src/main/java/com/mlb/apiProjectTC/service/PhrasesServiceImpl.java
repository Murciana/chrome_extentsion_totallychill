package com.mlb.apiProjectTC.service;

import com.mlb.apiProjectTC.model.Phrases;
import com.mlb.apiProjectTC.model.PhrasesDTO;
import org.springframework.stereotype.Service;
import com.mlb.apiProjectTC.repository.PhrasesRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhrasesServiceImpl implements PhrasesService{

    private final PhrasesRepository phrasesRepository;

    public PhrasesServiceImpl(PhrasesRepository phrasesRepository) {
        this.phrasesRepository = phrasesRepository;
    }

    @Override
    public List<PhrasesDTO> getAllPhrases() {
        return phrasesRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PhrasesDTO> getPhrasesById(Long id) {
        return phrasesRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public PhrasesDTO savePhrases(PhrasesDTO phrasesDTO) {
        Phrases phrases = convertToEntity(phrasesDTO);
        Phrases savedPhrases = phrasesRepository.save(phrases);
        return convertToDTO(savedPhrases);
    }

    @Override
    public PhrasesDTO updatePhrases(Long id, PhrasesDTO phrasesDTO) {
        Phrases phrases = phrasesRepository.findById(id).orElseThrow();
        phrases.setGoodVibePhrase(phrasesDTO.goodVibePhrase());
        Phrases updatedPhrases = phrasesRepository.save(phrases);
        return convertToDTO(updatedPhrases);
    }

    @Override
    public void deletePhrases(Long id) {
        phrasesRepository.deleteById(id);
    }

    // Convert Phrases Entity to PhrasesDTO
    private PhrasesDTO convertToDTO(Phrases phrases) {
        return new PhrasesDTO(phrases.getId(), phrases.getGoodVibePhrase());
    }

    // Convert PhrasesDTO to Phrases Entity
    private Phrases convertToEntity(PhrasesDTO phrasesDTO) {
        Phrases phrases = new Phrases();
        phrases.setGoodVibePhrase(phrasesDTO.goodVibePhrase());
        return phrases;
    }

}
