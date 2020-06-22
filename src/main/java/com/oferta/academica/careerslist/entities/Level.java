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

	private String name;
	
	public Level() {
		
	}

	public Level(int cod_level, String name) {
		super();
		this.cod_level = cod_level;
		this.name = name;
	}

	public int getCod_level() {
		return cod_level;
	}

	public void setCod_level(int cod_level) {
		this.cod_level = cod_level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
