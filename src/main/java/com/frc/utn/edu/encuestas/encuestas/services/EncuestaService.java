package com.frc.utn.edu.encuestas.encuestas.services;

import com.frc.utn.edu.encuestas.encuestas.entities.Encuesta;
import com.frc.utn.edu.encuestas.encuestas.repositories.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncuestaService {
    private EncuestaRepository encuestaRepository;
    public EncuestaService(EncuestaRepository encuestaRepository) {
        this.encuestaRepository = encuestaRepository;
    }

    public List<Encuesta> getAllEncuestas(){
        return encuestaRepository.findAll();
    }

    public Encuesta getById(Long id){
        Optional<Encuesta> encuesta = encuestaRepository.findById(id);
        return encuesta.get();
    }

    public void postEncuesta(Encuesta encuesta){
        encuestaRepository.save(encuesta);
    }

}
