package com.prueba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.entity.Persona;
import com.prueba.exception.RecordNotFoundException;
import com.prueba.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository repository;

    public List<Persona> getAllusers() {
        List<Persona> result = (List<Persona>) repository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Persona>();
        }
    }

    public Persona getUserById(Long id) throws RecordNotFoundException {
        Optional<Persona> user = repository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public Persona createOrUpdateUser(Persona entity) {
        if (entity.getId() == null) {
            entity = repository.save(entity);

            return entity;
        } else {
            Optional<Persona> user = repository.findById(entity.getId());

            if (user.isPresent()) {
                Persona newEntity = user.get();
                newEntity.setEmail(entity.getEmail());
                newEntity.setName(entity.getName());
                newEntity.setPhoneNumber(entity.getPhoneNumber());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteUserById(Long id) throws RecordNotFoundException {
        Optional<Persona> user = repository.findById(id);

        if (user.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}
