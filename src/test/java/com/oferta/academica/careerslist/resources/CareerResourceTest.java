package com.oferta.academica.careerslist.resources;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oferta.academica.careerslist.dtos.CareerDto;
import com.oferta.academica.careerslist.dtos.LevelDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CareerResourceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private RestService restService;
	private LevelDto levelDto;
	private CareerDto careerDto;

	@Before
	public void Before() {
		this.levelDto = new LevelDto(1, "Pregrado");
		this.careerDto = new CareerDto(12, "LICENCIATURA EN TURISMO", "Formar profesionales con valores éticos y humanistas, capaces de diseñar, planificar y gestionar empresas.", 
				"Guianza de Turismo.","Aprobación del curso de nivelación o propedéutico.", "malla_curricular", "Presencial", this.levelDto);
	}

	@Test
	public void createCareer() {
		restService.restBuilder().path(CareerResource.CAREER).body(careerDto).post().build();
	}
	
	@Test
	public void readAllCareersTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CareerResource.CAREER).path(CareerResource.ID).expand(10).get().build();
		
		System.out.println("-->"+ json);
	}
	
	@Test
	public void readCareerByIdTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CareerResource.CAREER).path(CareerResource.ID).expand(10).get().build();
		
		System.out.println("-->"+ json);
	}
	
	@Test
	public void editCareerTest() {
		this.careerDto.setNombre("LICENCIATURA EN GASTRONOMÍA");
		this.careerDto.setObjetivo("Formar profesionales con valores éticos y humanistas, capaces de diseñar, planificar y gestionar empresas gastronómicas.");
		this.careerDto.setCampo_ocupacional("Planificación, implementación y ejecución de proyectos Gastronómicos");
		this.careerDto.setRequisitos("Aprobación del curso de nivelación o propedéutico.");
		this.careerDto.setMalla_curricular("malla_curricular");
		this.careerDto.setModalidad("Presencial");
		this.levelDto.setCod_level(1);
		restService.restBuilder().path(CareerResource.CAREER).path(CareerResource.ID)
		.expand(9).body(careerDto).put().build();
	}	
	
}
