package com.oferta.academica.careerslist.dtos;

import com.oferta.academica.careerslist.entities.Level;

public class LevelDto {

	private int cod_level;

	private String name;
	
	public LevelDto() {
		
	}

	public LevelDto(int cod_level, String name) {
		super();
		this.cod_level = cod_level;
		this.name = name;
	}
	
	
	public LevelDto (Level level) {
		this.cod_level= level.getCod_level();
		this.name= level.getName();
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
