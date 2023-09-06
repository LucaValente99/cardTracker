package com.luca.cardTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luca.cardTracker.businesscomponent.model.CardSet;
import com.luca.cardTracker.businesscomponent.model.Carta;

@Repository("CartaRepository")
public interface CartaRepository extends JpaRepository<Carta, String>{
	@Query(value = "SELECT * FROM Carta WHERE codice_carta = ?1", nativeQuery = true)
	Optional<Carta> findByCodice(String Codice);
	
	@Query(value = "SELECT * FROM Carta WHERE id_card_set = ?1 "
			+ "ORDER BY codice_carta", nativeQuery = true)
	List<Carta> findByCardSet(CardSet cardSet);
	
	@Query(value = "SELECT * FROM Carta WHERE id_card_set = ?1 "
			+ "ORDER BY prezzo_carta", nativeQuery = true)
	List<Carta> findByCardSetOrderedByPrezzo(CardSet cardSet);
}
