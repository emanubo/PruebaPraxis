package com.prueba.repository;

import com.prueba.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
