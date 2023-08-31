package com.luca.cardTracker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luca.cardTracker.businesscomponent.model.CardSet;
import com.luca.cardTracker.repository.CardSetRepository;
import com.luca.cardTracker.service.CardSetService;

@Service
public class CardSetServiceImpl implements CardSetService{
	
	@Autowired 
	private CardSetRepository cardSetRepository;

	@Override
	public List<CardSet> getAll() {
		return cardSetRepository.findAll();
	}

	@Override
	public boolean deleteCardSet(CardSet cardSet) {
		cardSetRepository.delete(cardSet);
		return true;
	}

	@Override
	public boolean saveCardSet(CardSet cardSet) {
		cardSetRepository.save(cardSet);
		return true;
	}

	@Override
	public boolean updateCardSet(CardSet cardSet) {
		cardSetRepository.save(cardSet);
		return true;
	}

	@Override
	public List<CardSet> findByCategoria(String categoria) {
		return cardSetRepository.findByCategoria(categoria);
	}

	@Override
	public Optional<CardSet> findBySiglaSet(String nomeSet) {
		return cardSetRepository.findBySiglaSet(nomeSet);
	}
}
