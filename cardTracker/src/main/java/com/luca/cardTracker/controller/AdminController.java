package com.luca.cardTracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luca.cardTracker.businesscomponent.model.CardSet;
import com.luca.cardTracker.businesscomponent.model.Carta;
import com.luca.cardTracker.service.CardSetService;
import com.luca.cardTracker.service.CartaService;

@Controller
@Scope("session")
public class AdminController {
	
	@Autowired
	private CartaService cartaService;
	
	@Autowired
	private CardSetService cardSetService;
	
	@GetMapping(value = {"", "/"})
	public ModelAndView home(Authentication auth, HttpSession session,  @RequestParam(name = "nomeCategoria", required = false) String nomeCategoria) {
		
		ModelAndView mv = new ModelAndView("home");
		session.setAttribute("utente_log", auth.getName());
		mv.addObject("username", auth.getName());
		
		
		List<CardSet> cardSets = null;
		
		if(nomeCategoria != null) {
			mv.addObject("nomeCategoria", nomeCategoria);
			cardSets = cardSetService.findByCategoria(nomeCategoria.trim());
		}
		else {
			mv.addObject("nomeCategoria", "YuGiOh!");
			cardSets = cardSetService.findByCategoria("YuGiOh!"); 
		}
		
		mv.addObject("cardSets", cardSets);
		
		return mv;	
	}
	
	@GetMapping("/pokemonSets")
	public String pokemonSets() {
		return "redirect:/?nomeCategoria=Pokemon";
	}
	
	@GetMapping("/magicSets")
	public String magicSets() {
		return "redirect:/?nomeCategoria=Magic";
	}
	
	@GetMapping("/monsterSets")
	public String monsterSets() {
		return "redirect:/?nomeCategoria=Monsters!";
	}
	
	@GetMapping("/aggiungiCarta")
	public ModelAndView aggiungiCarta(HttpSession session) {
		ModelAndView mv = new ModelAndView("aggiungiCarta");
		Carta carta = new Carta();
		mv.addObject("carta", carta);
		mv.addObject("username", session.getAttribute("utente_log"));
		return mv;
	}
	
	@PostMapping("/aggiungiCarta")
	public String aggiungiCarta(Carta carta, @RequestParam String siglaSet) throws Exception {
		
		CardSet cardSet = null;
		if(cardSetService.findBySiglaSet(siglaSet.trim()).isPresent()) {
			cardSet = cardSetService.findBySiglaSet(siglaSet.trim()).get();
			carta.setCardSet(cardSet);
		    cartaService.saveCarta(carta);
		    cardSet.setNumeroCartePossedute(cardSet.getNumeroCartePossedute()+1);
		    cardSet.setNumeroCarteRimanenti(cardSet.getNumeroCarteRimanenti()-1);
		}else {
			throw new Exception("La sigla inserita non esiste!");
		}
		
		return "redirect:/?nomeCategoria=" + cardSet.getCategoriaSet();
	}
	
	@GetMapping("/aggiungiSet")
	public ModelAndView aggiungiSet(HttpSession session) {
		ModelAndView mv = new ModelAndView("aggiungiSet");
		CardSet cardSet = new CardSet();
		mv.addObject("cardSet", cardSet);
		mv.addObject("username", session.getAttribute("utente_log"));
		return mv;
	}
	
	@PostMapping("/aggiungiSet")
	public String aggiungiSet(CardSet cardSet) {
	    cardSetService.saveCardSet(cardSet);	    
		return "redirect:/?nomeCategoria=" + cardSet.getCategoriaSet();
	}
	
	@GetMapping("/visualizzaSet/{siglaSet}")
	public ModelAndView visualizzaSet(@PathVariable String siglaSet, HttpSession session) {
		ModelAndView mv = new ModelAndView("cardSet");
		CardSet cardSet = cardSetService.findBySiglaSet(siglaSet).get();
		List<Carta> listaCarteSet = cartaService.findByCardSet(cardSet);
		
		mv.addObject("nomeSet", cardSet.getNomeSet());
		mv.addObject("siglaSet", cardSet.getSiglaSet());
		mv.addObject("listaCarteSet", listaCarteSet);
		mv.addObject("username", session.getAttribute("username"));
		return mv;
	}
}
