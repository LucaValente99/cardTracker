package com.luca.cardTracker.businesscomponent.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table
public class Carta implements Serializable{
	private static final long serialVersionUID = -1339961243177999631L;
	
	@Id
	private String codiceCarta;
	
	@Column(nullable = false)
	private String nomeCarta;
	
	@Column(nullable = false)
	@Check(constraints = "raritaCarta IN ('C', 'R', 'SR', 'UR', 'RS')")
	private String raritaCarta;
	
	@Column
	private double prezzoCarta;
	
	@Column
	private String descrizioneCarta;
	
	@Column(nullable = false)
	private boolean posseduta = false;
	
	@ManyToOne(cascade = CascadeType.ALL)  //Garantisce aggiornamento ed eliminazione a cascata dei record
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
