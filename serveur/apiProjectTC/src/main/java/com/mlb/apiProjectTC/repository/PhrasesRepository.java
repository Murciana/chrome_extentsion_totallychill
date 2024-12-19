package com.mlb.apiProjectTC.repository;

import com.mlb.apiProjectTC.model.Phrases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PhrasesRepository extends JpaRepository<Phrases, Long> {
}
