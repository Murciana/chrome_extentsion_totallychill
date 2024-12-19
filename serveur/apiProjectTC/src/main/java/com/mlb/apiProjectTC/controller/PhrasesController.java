package com.mlb.apiProjectTC.controller;

import com.mlb.apiProjectTC.model.PhrasesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mlb.apiProjectTC.service.PhrasesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phrases")
@CrossOrigin(origins = "https://github.com")
public class PhrasesController {

    private final PhrasesService phrasesService;

    public PhrasesController(PhrasesService phrasesService) {
        this.phrasesService = phrasesService;
    }

    @GetMapping
    public List<PhrasesDTO> getAllPhrases() {
        return phrasesService.getAllPhrases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhrasesDTO> getPhrasesById(@PathVariable Long id) {
        Optional<PhrasesDTO> phrases = phrasesService.getPhrasesById(id);
        return phrases.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhrasesDTO createPhrases(@RequestBody PhrasesDTO phrasesDTO) {
        return phrasesService.savePhrases(phrasesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhrasesDTO> updatePhrases(@PathVariable Long id, @RequestBody PhrasesDTO phrasesDTO) {
        try {
            PhrasesDTO updatedPhrases = phrasesService.updatePhrases(id, phrasesDTO);
            return ResponseEntity.ok(updatedPhrases);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhrases(@PathVariable Long id) {
        phrasesService.deletePhrases(id);
        return ResponseEntity.noContent().build();
    }

}
