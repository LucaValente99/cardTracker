package com.luca.cardTracker.service;

import java.util.List;
import java.util.Optional;

import com.luca.cardTracker.businesscomponent.model.CardSet;
import com.luca.cardTracker.businesscomponent.model.Carta;

public interface CartaService {
	List<Carta> getCarte();
	boolean deleteCarta(Carta carta);
	boolean saveCarta(Carta carta);
	boolean updateCarta(Carta carta);
	Optional<Carta> findByCodice(String codice);
	List<Carta> findByCardSet(CardSet cardSet);
	List<Carta> findByCardSetOrderedByPrezzo(CardSet cardSet);
}
