package com.oferta.academica.careerslist.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oferta.academica.careerslist.controllers.LevelController;
import com.oferta.academica.careerslist.dtos.LevelDto;
import com.oferta.academica.careerslist.resources.exception.LevelCreateError;
import com.oferta.academica.careerslist.resources.exception.LevelDontFound;

@RestController
@RequestMapping (LevelResource.LEVEL)
public class LevelResource {

	public static final String LEVEL = "/level";
	public static final String ID= "/{id}";
	
	@Autowired
	private LevelController levelcontroller;
	
	@PostMapping
	public void createLevel(@Valid @RequestBody LevelDto levelDto) throws LevelCreateError{
		this.levelcontroller.createLevel(levelDto);
	}
	
	@GetMapping
	public List<LevelDto>readAllLevels(){
		return this.levelcontroller.readAllLevels();
	}
	
	@GetMapping (value = ID)
	public LevelDto readLevelById(@PathVariable int id) throws LevelDontFound{
		return this.levelcontroller.findLevelById(id).orElseThrow(()-> new LevelDontFound());
	}
	
	@PutMapping (value = ID)
	public void editLevel(@PathVariable int id, @Valid @RequestBody LevelDto levelDto) throws LevelDontFound{
		if (this.levelcontroller.editLevel(id, levelDto)) throw new LevelDontFound();
	}
}
