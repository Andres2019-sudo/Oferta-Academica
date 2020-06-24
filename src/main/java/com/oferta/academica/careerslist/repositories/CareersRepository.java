package com.oferta.academica.careerslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oferta.academica.careerslist.entities.Career;

public interface CareersRepository extends JpaRepository<Career, Integer>{

}
