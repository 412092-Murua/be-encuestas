package com.frc.utn.edu.encuestas.encuestas.services;

import com.frc.utn.edu.encuestas.encuestas.entities.Encuesta;
import com.frc.utn.edu.encuestas.encuestas.entities.Pregunta;
import com.frc.utn.edu.encuestas.encuestas.entities.Respuesta;
import com.frc.utn.edu.encuestas.encuestas.repositories.EncuestaRepository;
import com.frc.utn.edu.encuestas.encuestas.repositories.PreguntaRepository;
import com.frc.utn.edu.encuestas.encuestas.repositories.RespuestaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    private EncuestaRepository encuestaRepository;
    private RespuestaRepository respuestaRepository;
    private PreguntaRepository preguntaRepository;

    public RespuestaService(PreguntaRepository preguntaRepository,RespuestaRepository respuestaRepository, EncuestaRepository encuestaRepository) {
        this.respuestaRepository = respuestaRepository;
        this.encuestaRepository = encuestaRepository;
        this.preguntaRepository = preguntaRepository;
    }

    // TODO RECIBIR RespuestaDTO con respuestas para una encuesta

    public Long getEstadisticas(Long id){

        Optional<Encuesta> encuesta = encuestaRepository.findById(id);
        if (!encuesta.isPresent()) {
            return null;
        }



//        if (pregunta == null) {
//            return null;
//        }
//        List<Respuesta> respuestas = respuestaRepository.findAll();
//
        return null;
    }

}
