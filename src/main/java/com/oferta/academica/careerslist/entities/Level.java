package com.oferta.academica.careerslist.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod_level;

	private int cod_pregrado, cod_postgrado;
	
	public Level() {
		
	}

	public Level(int cod_level, int cod_pregrado, int cod_postgrado) {
		super();
		this.cod_level = cod_level;
		this.cod_pregrado = cod_pregrado;
		this.cod_postgrado = cod_postgrado;
	}

	public int getCod_level() {
		return cod_level;
	}

	public void setCod_level(int cod_level) {
		this.cod_level = cod_level;
	}

	public int getCod_pregrado() {
		return cod_pregrado;
	}

	public void setCod_pregrado(int cod_pregrado) {
		this.cod_pregrado = cod_pregrado;
	}

	public int getCod_postgrado() {
		return cod_postgrado;
	}

	public void setCod_postgrado(int cod_postgrado) {
		this.cod_postgrado = cod_postgrado;
	}
	
}
