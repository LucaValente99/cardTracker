package com.luca.cardTracker.businesscomponent.model.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.luca.cardTracker.businesscomponent.model.Carta;

public class CartaComparatorRarita implements Comparator<Carta>{

	Map<String, Integer> ORDINE_RARITA = new HashMap<String, Integer>();
	
	public CartaComparatorRarita() {
		ORDINE_RARITA.put("C", 1);
		ORDINE_RARITA.put("R", 2);
		ORDINE_RARITA.put("SR", 3);
		ORDINE_RARITA.put("UR", 4);
		ORDINE_RARITA.put("RS", 5);
	}
	
	@Override
	public int compare(Carta o1, Carta o2) {
		return ORDINE_RARITA.get(o1.getRaritaCarta()) - ORDINE_RARITA.get(o2.getRaritaCarta());
	}
	
}
