package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.entity.Persona;
import com.prueba.exception.RecordNotFoundException;
import com.prueba.service.PersonaService;

@RestController

public class WebController {

    @Autowired
    PersonaService service;

    @GetMapping({"/getAllUsers"})
    public ResponseEntity<List<Persona>> getAllUsers() {
        List<Persona> list = service.getAllusers();
        return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUserById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteUserById(id);

    }

    @PostMapping(path = "/createUser")
    public Persona createOrUpdateUser(@RequestBody Persona user) {
        return service.createOrUpdateUser(user);

    }

}
