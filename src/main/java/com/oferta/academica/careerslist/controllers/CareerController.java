package com.oferta.academica.careerslist.controllers;

import java.util.ArrayList;
import java.util.List;
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
	
	public Optional<Career> getCareerById(int id){
		Optional<Career> careerOptional = this.careersRepository.findById(id);
		return careerOptional;
	}
	
	public String createCareer(CareerDto careerDto) {
		Optional<Level>levelOptional = this.levelController.getLevelById(careerDto.getLevel().getCod_level());
		if (!levelOptional.isPresent())
			return "level";
		Level level = levelOptional.get();
		Career career = new Career(careerDto.getCod_careers(), careerDto.getNombre(),careerDto.getObjetivo(), careerDto.getPerfil_egreso(), careerDto.getTitulo(),
				careerDto.getCampo_ocupacional(),careerDto.getRequisitos(),careerDto.getMalla_curricular(),
				careerDto.getModalidad(), careerDto.getImagen(),level);
		this.careersRepository.save(career);
		return "created";
	}
	
	public List<CareerDto> readAllCareers(){
		List<Career> careerList = this.careersRepository.findAll();
		List<CareerDto> careerListDto = new ArrayList<CareerDto>();
		for (Career career : careerList) {
			careerListDto.add(new CareerDto(career));
		}
		return careerListDto;
	}
	
	public Optional<CareerDto> findCareerById (int id){
		Optional<Career> careerOptional = this.getCareerById(id);
		if (careerOptional.isPresent()) {
			return Optional.of(new CareerDto(careerOptional.get()));
		}else {
			return Optional.empty();
		}
	}
	
	public boolean editCareer(int id, CareerDto careerDto) {
		Optional<Career> careerOptional = this.getCareerById(id);
		if (!careerOptional.isPresent())
		return false;
		Optional<Level> levOptional = this.levelController
				.getLevelById(careerDto.getLevel().getCod_level());
		if (!levOptional.isPresent())
			return false;
		Career career = careerOptional.get();
		career.setNombre(careerDto.getNombre());
		career.setObjetivo(careerDto.getObjetivo());
		career.setCampo_ocupacional(careerDto.getCampo_ocupacional());
		career.setRequisitos(careerDto.getRequisitos());
		career.setMalla_curricular(careerDto.getMalla_curricular());
		career.setModalidad(careerDto.getModalidad());
		career.setPerfil_egreso(careerDto.getPerfil_egreso());
		career.setTitulo(careerDto.getTitulo());
		career.setImagen(careerDto.getImagen());
		career.setLevel(levOptional.get());
		this.careersRepository.save(career);
		return true;
	}
}
