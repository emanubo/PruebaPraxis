package com.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prueba.entity.Persona;
import com.prueba.repository.PersonaRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PersonaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Persona("Edwin", "Bohórquez", "abcdef@gmail.com"));
        repository.save(new Persona("Manuel", "Garcia", "123@gmail.com"));

    }

}
