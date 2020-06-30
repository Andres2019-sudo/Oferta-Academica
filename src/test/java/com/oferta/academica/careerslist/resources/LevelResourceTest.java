package com.oferta.academica.careerslist.resources;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oferta.academica.careerslist.dtos.LevelDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LevelResourceTest {
	
	@Rule
	public ExpectedException thrown= ExpectedException.none();

	@Autowired
	private RestService restService;
	private LevelDto levelDto;
	
	@Before
	public void before(){
		this.levelDto= new LevelDto(2, "Post Grado");
	}
	
	@Test
	public void createLevelTest() {
		restService.restBuilder().path(LevelResource.LEVEL).body(levelDto).post().build();
		}	
	
}
