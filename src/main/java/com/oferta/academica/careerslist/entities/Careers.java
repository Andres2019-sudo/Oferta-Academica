package com.oferta.academica.careerslist.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Careers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod_careers;
	
	private String objetivo, modalidad, campo_ocupacional, requisitos, malla_curricular;
	
	public Careers() {
		
	}

	public Careers(int cod_careers, String objetivo, String modalidad, String campo, malla curricular) {
		super();
		this.cod_careers = cod_careers;
		this.objetivo = objetivo;
		this.modalidad = modalidad;
		this.campo_ocupacional = campo;
		this.malla_curricular = curricular;
	}

	public int getCod_careers() {
		return cod_careers;
	}

	public void setCod_careers(int cod_careers) {
		this.cod_careers = cod_careers;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
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

}
