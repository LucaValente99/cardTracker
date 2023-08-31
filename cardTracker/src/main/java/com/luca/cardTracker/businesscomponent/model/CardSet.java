package com.luca.cardTracker.businesscomponent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table
public class CardSet implements Serializable{
	private static final long serialVersionUID = -5878384509686506571L;

	@Id
	private String siglaSet;
	
	@Column(nullable = false)
	private String nomeSet;
	
	@Column(nullable = false)
	@Check(constraints = "categoriaSet IN ('YuGiOh!', 'Pokemon', 'Magic', 'Monsters!')")
	private String categoriaSet;
	
	@Column(nullable = false)
	private int numeroCarteSet;
	
	@Column(nullable = false)
	private int numeroCartePossedute;
	
	@Column(nullable = false)
	private int numeroCarteRimanenti;

	public String getNomeSet() {
		return nomeSet;
	}

	public void setNomeSet(String nomeSet) {
		this.nomeSet = nomeSet;
	}

	public String getCategoriaSet() {
		return categoriaSet;
	}

	public void setCategoriaSet(String categoriaSet) {
		this.categoriaSet = categoriaSet;
	}

	public int getNumeroCarteSet() {
		return numeroCarteSet;
	}

	public void setNumeroCarteSet(int numeroCarteSet) {
		this.numeroCarteSet = numeroCarteSet;
	}

	public int getNumeroCartePossedute() {
		return numeroCartePossedute;
	}

	public void setNumeroCartePossedute(int numeroCartePossedute) {
		this.numeroCartePossedute = numeroCartePossedute;
	}

	public int getNumeroCarteRimanenti() {
		return numeroCarteRimanenti;
	}

	public void setNumeroCarteRimanenti(int numeroCarteRimanenti) {
		this.numeroCarteRimanenti = numeroCarteRimanenti;
	}

	public String getSiglaSet() {
		return siglaSet;
	}

	public void setSiglaSet(String siglaSet) {
		this.siglaSet = siglaSet;
	}
	
}
