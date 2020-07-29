package com.oferta.academica.careerslist.dtos;

import com.oferta.academica.careerslist.entities.Career;

public class CareerDto {

	private int cod_careers;

	private String nombre,objetivo, campo_ocupacional, requisitos, malla_curricular, modalidad, perfil_egreso, titulo, imagen;
	
	private LevelDto level;
	
	public CareerDto () {
		
	}

	public CareerDto(int cod_careers, String nombre, String objetivo, String campo_ocupacional, String requisitos,
			String malla_curricular, String modalidad, String perfil_egreso, String titulo, String imagen, LevelDto level) {
		super();
		this.cod_careers = cod_careers;
		this.nombre = nombre;
		this.objetivo = objetivo;
		this.campo_ocupacional = campo_ocupacional;
		this.requisitos = requisitos;
		this.malla_curricular = malla_curricular;
		this.modalidad = modalidad;
		this.perfil_egreso = perfil_egreso;
		this.titulo = titulo;
		this.imagen = imagen;
		this.level = level;
	}
	
	public CareerDto(Career career) {
		this.cod_careers= career.getCod_careers();
		this.nombre = career.getNombre();
		this.objetivo= career.getObjetivo();
		this.campo_ocupacional= career.getCampo_ocupacional();
		this.requisitos= career.getRequisitos();
		this.malla_curricular= career.getMalla_curricular();
		this.modalidad= career.getModalidad();
		this.perfil_egreso = career.getPerfil_egreso();
		this.titulo = career.getTitulo();
		this.imagen = career.getImagen();
		this.level= new LevelDto (career.getLevel());
	}

	public int getCod_careers() {
		return cod_careers;
	}

	public void setCod_careers(int cod_careers) {
		this.cod_careers = cod_careers;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getCampo_ocupacional() {
		return campo_ocupacional;
	}

	public void setCampo_ocupacional(String campo_ocupacional) {
		this.campo_ocupacional = campo_ocupacional;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getMalla_curricular() {
		return malla_curricular;
	}

	public void setMalla_curricular(String malla_curricular) {
		this.malla_curricular = malla_curricular;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
	public String getPerfil_egreso () {
		return perfil_egreso;
	}
	
	public void setPerfil_egreso (String perfil_egreso) {
		this.perfil_egreso = perfil_egreso;
	}
	
	public String getTitulo () {
		return titulo;
	}
	
	public void setTitulo (String titulo) {
		this.titulo = titulo;
	}
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen (String imagen) {
		this.imagen = imagen;
	}

	public LevelDto getLevel() {
		return level;
	}

	public void setLevel(LevelDto level) {
		this.level = level;
	}
		
}
