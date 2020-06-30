package com.oferta.academica.careerslist.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oferta.academica.careerslist.controllers.LevelController;
import com.oferta.academica.careerslist.dtos.LevelDto;
import com.oferta.academica.careerslist.resources.exception.LevelCreateError;

@RestController
@RequestMapping (LevelResource.LEVEL)
public class LevelResource {

	public static final String LEVEL = "/level";
	
	@Autowired
	private LevelController levelcontroller;
	
	@PostMapping
	public void createLevel(@Valid @RequestBody LevelDto levelDto) throws LevelCreateError{
		this.levelcontroller.createLevel(levelDto);
	}
	
}
