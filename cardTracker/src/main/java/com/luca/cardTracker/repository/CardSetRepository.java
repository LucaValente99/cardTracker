package com.luca.cardTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luca.cardTracker.businesscomponent.model.CardSet;

@Repository("CardSetRepository")
public interface CardSetRepository extends JpaRepository<CardSet, String>{
	@Query(value="SELECT * FROM card_set WHERE categoria_set = ?1", nativeQuery = true)
	List<CardSet> findByCategoria(String categoria);
	
	@Query(value="SELECT * FROM card_set WHERE sigla_set = ?1", nativeQuery = true)
	Optional<CardSet> findBySiglaSet(String nomeSet);
}
