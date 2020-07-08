package com.oferta.academica.careerslist.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.oferta.academica.careerslist.dtos.LevelDto;
import com.oferta.academica.careerslist.entities.Level;
import com.oferta.academica.careerslist.repositories.LevelRepository;


@Controller
public class LevelController {

	@Autowired
	private LevelRepository levelRepository;
	
	public Optional<Level> getLevelById(int id) {
		Optional<Level> levelOptional = this.levelRepository.findById(id);
		return levelOptional;
	}
	
	public void createLevel(LevelDto levelDto) {
		Level level= new Level(levelDto.getCod_level(),levelDto.getName());
		this.levelRepository.save(level);
	}
 	
	public List<LevelDto>readAllLevels(){
		List<Level> levelList = this.levelRepository.findAll();
		List<LevelDto>levelsDto = new ArrayList<LevelDto>();
		for (Level level: levelList) {
			levelsDto.add(new LevelDto(level));
		}
		return levelsDto;
		
	}
	
	public Optional<LevelDto> findLevelById (int id){
		Optional<Level>levelOptional = this.getLevelById(id);
		if(levelOptional.isPresent ()) {
			return Optional.of(new LevelDto(levelOptional.get()));
		}else {
			return Optional.empty();
		}
	}
	
	public boolean editLevel(int id, LevelDto levelDto) {
		Optional<Level> levOptional = this.getLevelById(id);
		if (!levOptional.isPresent()) 
			return false;
		Level level= levOptional.get();
		level.setName(levelDto.getName());
		this.levelRepository.save(level);
		return false;
	}	
}
