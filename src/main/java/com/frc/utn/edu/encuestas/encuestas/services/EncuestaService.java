package com.frc.utn.edu.encuestas.encuestas.services;

import com.frc.utn.edu.encuestas.encuestas.DTOs.EncuestaWithoutPreguntasDto;
import com.frc.utn.edu.encuestas.encuestas.entities.Encuesta;
import com.frc.utn.edu.encuestas.encuestas.repositories.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EncuestaService {
    @Autowired
    private EncuestaRepository encuestaRepository;

    public List<EncuestaWithoutPreguntasDto> getAllEncuestas() {
        List<Encuesta> encuestas = encuestaRepository.findAll();
        List<EncuestaWithoutPreguntasDto> encuestasWithoutPreguntas = new ArrayList<>();
        for (Encuesta encuesta : encuestas) {
            EncuestaWithoutPreguntasDto encuestaDto = EncuestaWithoutPreguntasDto.builder()
                    .id(encuesta.getId())
                    .titulo(encuesta.getTitulo())
                    .build();
            encuestasWithoutPreguntas.add(encuestaDto);
        }
        return encuestasWithoutPreguntas;
    }

    public Encuesta getById(Long id) {
        Optional<Encuesta> encuesta = encuestaRepository.findById(id);
        if (!encuesta.isPresent()) {
            throw new RuntimeException("Encuesta con id " + id + " no encontrada");
        }
        return encuesta.get();
    }

    // public void postEncuesta(Encuesta encuesta) {
    //     encuestaRepository.save(encuesta);
    // }

}
