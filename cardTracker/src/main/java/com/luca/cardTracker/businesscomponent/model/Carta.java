package com.luca.cardTracker.businesscomponent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Carta implements Serializable{
	private static final long serialVersionUID = -1339961243177999631L;
	
	@Id
	@Size(min=6, max=15, message = "da 6 a 15 caratteri (es. LOB-EN001)")
	@NotBlank(message = "Il codice della carta non può essere nullo")
	private String codiceCarta;
	
	@Size(min=2, max=30, message = "da 2 a 30 caratteri")
	@NotBlank(message = "Il nome della carta non può essere nullo")
	@Column(nullable = false)
	private String nomeCarta;
	
	@NotBlank(message = "La rarità della carta non può essere nulla")
	@Pattern(regexp = "(C|R|SR|UR|RS)", message="Valori accettati: 'C', 'R', 'SR', 'UR', 'RS'")
	@Column(nullable = false)
	private String raritaCarta;
	
	@Column
	private double prezzoCarta;
	
	@Column
	private String descrizioneCarta;
	
	@Column(nullable = false)
	private boolean posseduta;
	
	@ManyToOne()
	@JoinColumn(name = "id_cardSet") //Questo mi permette semplicemente di assegnare il nome alla fk
	private CardSet cardSet;

	public String getCodiceCarta() {
		return codiceCarta;
	}

	public void setCodiceCarta(String codiceCarta) {
		this.codiceCarta = codiceCarta;
	}

	public String getNomeCarta() {
		return nomeCarta;
	}

	public void setNomeCarta(String nomeCarta) {
		this.nomeCarta = nomeCarta;
	}

	public String getRaritaCarta() {
		return raritaCarta;
	}

	public void setRaritaCarta(String raritaCarta) {
		this.raritaCarta = raritaCarta;
	}

	public String getDescrizioneCarta() {
		return descrizioneCarta;
	}

	public void setDescrizioneCarta(String descrizioneCarta) {
		this.descrizioneCarta = descrizioneCarta;
	}

	public CardSet getCardSet() {
		return cardSet;
	}

	public void setCardSet(CardSet cardSet) {
		this.cardSet = cardSet;
	}

	public double getPrezzoCarta() {
		return prezzoCarta;
	}

	public void setPrezzoCarta(double prezzo) {
		this.prezzoCarta = prezzo;
	}

	public boolean isPosseduta() {
		return posseduta;
	}

	public void setPosseduta(boolean posseduta) {
		this.posseduta = posseduta;
	}	
}
