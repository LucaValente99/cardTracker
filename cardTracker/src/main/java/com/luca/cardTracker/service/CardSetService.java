package com.luca.cardTracker.service;

import java.util.List;
import java.util.Optional;

import com.luca.cardTracker.businesscomponent.model.CardSet;

public interface CardSetService {
	List<CardSet> getAll();
	boolean deleteCardSet(CardSet cardSet);
	boolean saveCardSet(CardSet cardSet);
	boolean updateCardSet(CardSet cardSet);
	List<CardSet> findByCategoria(String categoria);
	Optional<CardSet> findBySiglaSet(String nomeSet);
}
