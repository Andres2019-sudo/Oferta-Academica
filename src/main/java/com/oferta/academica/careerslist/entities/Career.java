package com.oferta.academica.careerslist.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Career {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod_careers;

	private String objetivo, campo_ocupacional, requisitos, malla_curricular;

	@Column(length = 50)
	private String modalidad;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Level level;

	public Career() {
	}

	public Career(int cod_careers, String objetivo, String campo_ocupacional, String requisitos,
			String malla_curricular, String modalidad, Level level) {
		super();
		this.cod_careers = cod_careers;
		this.objetivo = objetivo;
		this.campo_ocupacional = campo_ocupacional;
		this.requisitos = requisitos;
		this.malla_curricular = malla_curricular;
		this.modalidad = modalidad;
		this.level = level;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}