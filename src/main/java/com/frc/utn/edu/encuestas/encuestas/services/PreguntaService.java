package com.frc.utn.edu.encuestas.encuestas.services;

import com.frc.utn.edu.encuestas.encuestas.repositories.PreguntaRepository;
import org.springframework.stereotype.Service;

@Service
public class PreguntaService {
    private PreguntaRepository preguntaRepository;
    public PreguntaService(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }


}
