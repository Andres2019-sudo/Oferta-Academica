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
		this.careerDto = new CareerDto(5, "LICENCIATURA EN ADMINISTRACIÓN DE EMPRESAS", "Formar profesionales con competencias emprendedoras y gerenciales para tomar decisiones, gestionar el cambio e implementar estrategias.", 
				"Directores de empresas de abastecimiento, distribución y afines Gerentes de comercios al por mayor y al por menor","Aprobación del curso de nivelación o propedéutico.", "malla_curricular", "Presencial y semipresencial", this.levelDto);
	}

	@Test
	public void createCareer() {
		restService.restBuilder().path(CareerResource.CAREER).body(careerDto).post().build();
	}
	
	@Test
	public void readAllCareersTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CareerResource.CAREER).path(CareerResource.ID).expand(7).get().build();
		
		System.out.println("-->"+ json);
	}
	
	@Test
	public void readCareerByIdTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CareerResource.CAREER).path(CareerResource.ID).expand(7).get().build();
		
		System.out.println("-->"+ json);
	}
	
	@Test
	public void editCareerTest() {
		this.careerDto.setNombre("LICENCIATURA EN ENFERMERÍA");
		this.careerDto.setObjetivo("Formar un profesional de altos valores éticos y sólida formación teórica y práctica, capaz de intervenir en procesos dirigidos al cuidado médico asistencial.");
		this.careerDto.setCampo_ocupacional("Sector Salud, Sector Educación, Sector Justicia y Derechos Penales");
		this.careerDto.setRequisitos("Aprobación del curso de nivelación o propedéutico.");
		this.careerDto.setMalla_curricular("malla_curricular");
		this.careerDto.setModalidad("Presencial");
		this.levelDto.setCod_level(1);
		restService.restBuilder().path(CareerResource.CAREER).path(CareerResource.ID)
		.expand(11).body(careerDto).put().build();
	}	
	
}
