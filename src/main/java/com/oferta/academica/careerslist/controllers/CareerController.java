package com.oferta.academica.careerslist.controllers;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.oferta.academica.careerslist.dtos.CareerDto;
import com.oferta.academica.careerslist.entities.Career;
import com.oferta.academica.careerslist.entities.Level;
import com.oferta.academica.careerslist.repositories.CareersRepository;

@Controller
public class CareerController {

	@Autowired
	private CareersRepository careersRepository;
	
	@Autowired
	private LevelController levelController;
	
	public String createCareer(CareerDto careerDto) {
		Optional<Level>levelOptional = this.levelController.getLevelById(careerDto.getLevel().getCod_level());
		if (!levelOptional.isPresent())
			return "level";
		Level level = levelOptional.get();
		Career career = new Career(careerDto.getCod_careers(), careerDto.getNombre(),careerDto.getObjetivo(),
				careerDto.getCampo_ocupacional(),careerDto.getRequisitos(),careerDto.getMalla_curricular(),
				careerDto.getModalidad(),level);
		this.careersRepository.save(career);
		return "created";
	}
}
