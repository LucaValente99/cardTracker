package com.luca.cardTracker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luca.cardTracker.businesscomponent.model.CardSet;
import com.luca.cardTracker.businesscomponent.model.Carta;
import com.luca.cardTracker.repository.CartaRepository;
import com.luca.cardTracker.service.CartaService;

@Service
public class CartaServiceImpl implements CartaService {

	@Autowired
	private CartaRepository cartaRepository;
	
	@Override
	public List<Carta> getCarte() {
		return cartaRepository.findAll();
	}

	@Override
	public Optional<Carta> findByCodice(String Codice) {
		return cartaRepository.findByCodice(Codice);
	}

	@Override
	public boolean deleteCarta(Carta carta) {
		cartaRepository.delete(carta);
		return true;
	}

	@Override
	public boolean saveCarta(Carta carta) {
		cartaRepository.save(carta);
		return true;
	}

	@Override
	public boolean updateCarta(Carta carta) {
		cartaRepository.save(carta);
		return true;
	}

	@Override
	public List<Carta> findByCardSet(CardSet cardSet) {
		return cartaRepository.findByCardSet(cardSet);
	}

}
