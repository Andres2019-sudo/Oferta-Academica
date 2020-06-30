package com.oferta.academica.careerslist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.oferta.academica.careerslist.dtos.LevelDto;
import com.oferta.academica.careerslist.entities.Level;
import com.oferta.academica.careerslist.repositories.LevelRepository;

@Controller
public class LevelController {

	@Autowired
	private LevelRepository levelRepository;
	
	public void createLevel(LevelDto levelDto) {
		Level level= new Level(levelDto.getCod_level(),levelDto.getName());
		this.levelRepository.save(level);
	}
}
