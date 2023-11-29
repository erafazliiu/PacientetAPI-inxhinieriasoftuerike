package com.pacientetapi.sevices;

import com.pacientetapi.models.Pacientet;
import com.pacientetapi.repositories.PacientetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class PacientetServices {

    private final PacientetRepository pacientetRepository;
    public PacientetServices (PacientetRepository pacientetRepository) {
        this.pacientetRepository = pacientetRepository;
    }

    public Pacientet createPacient(Pacientet pacientet) {
        return pacientetRepository.save(pacientet);
    }

    public Pacientet getPacientetById(Long id) {
        return pacientetRepository.findById(id).orElse(null);
    }

    public List<Pacientet> getAllPacientet() {
        return pacientetRepository.findAll();
    }

    public void deleteById(Long id) {
        pacientetRepository.deleteById(id);
    }

    public Pacientet updatePacientet(Long id, Pacientet pacientet) {
        Pacientet pacentetToBeUpdated = getPacientetById(id);
        if (pacentetToBeUpdated == null) {
            return null;
        } else {
            pacentetToBeUpdated.setFirstName(pacientet.getFirstName());
            pacentetToBeUpdated.setLastName(pacientet.getLastName());
            pacentetToBeUpdated.setPhoneNumber(pacientet.getPhoneNumber());
            pacentetToBeUpdated.setGender(pacientet.getGender());
            pacentetToBeUpdated.setDateOfBirth(pacientet.getDateOfBirth());
            pacentetToBeUpdated.setPhoneNumber(pacientet.getPhoneNumber());
            return pacientetRepository.save(pacentetToBeUpdated);
        }
    }



















}
