package com.luca.cardTracker.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.cardTracker.businesscomponent.model.Carta;
import com.luca.cardTracker.service.CartaService;

@RestController
@RequestMapping("/api")
public class CartaRestController {
	
	@Autowired
	private CartaService cartaService;
	
	@GetMapping("/carte")
	public List<Carta> getClienti() {
		return cartaService.getCarte();
	}
	
	@GetMapping("/carta/{codice}")
	public Optional<Carta> getCarta(@PathVariable String codice) {
		return cartaService.findByCodice(codice);
	}
	
	@PostMapping("/save")
	public boolean saveCarta(@RequestBody Carta carta) {
		return cartaService.saveCarta(carta);
	}
	
	@PutMapping("/update")
	public boolean updateCarta(@RequestBody Carta carta) {
		return cartaService.updateCarta(carta);
	}
	
	@DeleteMapping("/delete")
	public boolean deleteCarta(@RequestBody Carta carta) {
		return cartaService.deleteCarta(carta);
	}
	
}
