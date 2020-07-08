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
		this.careerDto = new CareerDto(1, "nombre", "objetivo", "campo_ocupacional",
				"requisitos", "malla_curricular", "modalidad", this.levelDto);
	}

	@Test
	public void test() {
		restService.restBuilder().path(CareerResource.CAREER).body(careerDto).post().build();
	}
}
