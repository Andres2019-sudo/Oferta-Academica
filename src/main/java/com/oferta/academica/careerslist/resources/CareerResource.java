package com.oferta.academica.careerslist.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oferta.academica.careerslist.controllers.CareerController;
import com.oferta.academica.careerslist.dtos.CareerDto;
import com.oferta.academica.careerslist.resources.exception.CareerCreateError;
import com.oferta.academica.careerslist.resources.exception.LevelDontFound;

@RestController
@RequestMapping(CareerResource.CAREER)
public class CareerResource {
	
	public static final String CAREER ="/careers";
	
	@Autowired
	private CareerController careerController;
	
	@PostMapping
	public void createCareer(@Valid @RequestBody CareerDto careerDto) 
	throws CareerCreateError, LevelDontFound {
		if (this.careerController.createCareer(careerDto) == "level")
			throw new LevelDontFound();
	}

}
