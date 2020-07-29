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
		this.careerDto = new CareerDto(10, "LICENCIATURA EN TURISMO","OBJETIVO","CAMPO OCUPACIONAL","REQUISITOS","MALLA CURRICULAR",
				"MODALIDAD","PERFIL EGRESO","TITULO","IMAGEN",this.levelDto);
	}

	@Test
	public void createCareer() {
		restService.restBuilder().path(CareerResource.CAREER).body(careerDto).post().build();
	}
	
	@Test
	public void readAllCareersTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CareerResource.CAREER).path(CareerResource.ID).expand(1).get().build();
		
		System.out.println("-->"+ json);
	}
	
	@Test
	public void readCareerByIdTest() {
		String json = restService.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(CareerResource.CAREER).path(CareerResource.ID).expand(1).get().build();
		
		System.out.println("-->"+ json);
	}
	
	@Test
	public void editCareerTest() {
		this.careerDto.setNombre("Contabilidad y Auditoria");
		this.careerDto.setObjetivo("Formar profesionales en contabilidad y auditoría, con ética profesional y con amplios conocimientos técnicos, científicos y tecnológicos, en las áreas contable, financiera, tributaria, ambiental y de control; para resolver y proponer soluciones a los problemas de las entidades, organismos y empresas, contribuyendo al desarrollo de la provincia y del país.");
		this.careerDto.setCampo_ocupacional("Contador General, Administrador financiero, Contador de Gestión empresarial, Auditor Externo, Auditor Financiero, Auditor de Sistemas,Auditor Tributario, Controlador y Contador gubernamental, Emprendedor");
		this.careerDto.setRequisitos("Aprobación del curso de nivelación o propedéutico.");
		this.careerDto.setMalla_curricular("Contabilidad y Auditoria");
		this.careerDto.setModalidad("Semipresencial");
		this.careerDto.setPerfil_egreso("El egresado de la Carrera de Contabilidad y Auditoría tendrá sólidos conocimientos en contabilidad, auditoría, tributación, costos, gestión financiera, económica y laboral, fortalezas en el uso de utilitarios y software contables, destrezas en el manejo de cifras, así como reportes tanto contables como financieros, capacidad para desenvolverse en ambientes automatizados y congestionados, fluidez de operaciones, optimización de recursos, proactivo con lógica de prioridades, pensamiento crítico, toma de decisiones y resolución de conflictos en su ámbito profesional.");
		this.careerDto.setTitulo("Licenciado en Contabilidad y Auditoría");
		this.levelDto.setCod_level(1);
		restService.restBuilder().path(CareerResource.CAREER).path(CareerResource.ID)
		.expand(1).body(careerDto).put().build();
	}	
	
}
