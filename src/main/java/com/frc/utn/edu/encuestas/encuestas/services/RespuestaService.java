package com.frc.utn.edu.encuestas.encuestas.services;

import com.frc.utn.edu.encuestas.encuestas.DTOs.EncuestaDTO;
import com.frc.utn.edu.encuestas.encuestas.DTOs.EncuestaWithoutPreguntasDto;
import com.frc.utn.edu.encuestas.encuestas.DTOs.RespuestaDTO;
import com.frc.utn.edu.encuestas.encuestas.DTOs.Estadisticas.EstadisticaPreguntaDTO;
import com.frc.utn.edu.encuestas.encuestas.DTOs.Estadisticas.EstadisticasEncuestaDTO;
import com.frc.utn.edu.encuestas.encuestas.entities.Encuesta;
import com.frc.utn.edu.encuestas.encuestas.entities.Pregunta;
import com.frc.utn.edu.encuestas.encuestas.entities.Respuesta;
import com.frc.utn.edu.encuestas.encuestas.entities.Respuesta.RespuestaBuilder;
import com.frc.utn.edu.encuestas.encuestas.repositories.EncuestaRepository;
import com.frc.utn.edu.encuestas.encuestas.repositories.PreguntaRepository;
import com.frc.utn.edu.encuestas.encuestas.repositories.RespuestaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    @Autowired
    private EncuestaRepository encuestaRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private PreguntaRepository preguntaRepository;

    // TODO RECIBIR RespuestaDTO con respuestas para una encuesta

    public void createRespuestas(RespuestaDTO respuestaDTO) {
        List<Respuesta> respuestas = respuestaDTO.getRespuestas();
        if (respuestas.size() == 0) {
            throw new RuntimeException("No se recibieron respuestas para guardar");
        }

        Optional<Encuesta> encuesta = encuestaRepository.findById(respuestaDTO.getEncuestaId());
        if (!encuesta.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Encuesta no encontrada");
        }
        for (int i = 0; i < respuestas.size(); i++) {

            Optional<Pregunta> pregunta = preguntaRepository.findById(respuestas.get(i).getPregunta().getId());
            if (!pregunta.isPresent()) {
                continue;
            }

            Respuesta respuestaTransformada = Respuesta.builder()
                    .pregunta(respuestas.get(i).getPregunta())
                    .contenido(respuestas.get(i).getContenido())
                    .fechaRespuesta(LocalDateTime.now())
                    .build();
            respuestaRepository.save(respuestaTransformada);
        }
    }
   

    public EstadisticasEncuestaDTO getEstadisticas(Long id) {

        Encuesta encuesta = encuestaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));

        EstadisticasEncuestaDTO estadisticas = new EstadisticasEncuestaDTO();
        estadisticas.setEncuestaId(encuesta.getId());
        estadisticas.setTituloEncuesta(encuesta.getTitulo());

        List<EstadisticaPreguntaDTO> estadisticaPreguntaDTOs = new ArrayList<>();

        for (Pregunta pregunta : encuesta.getPreguntas()) {
            long cantidadRespuestas = respuestaRepository.countByPreguntaId(pregunta.getId());
            
            EstadisticaPreguntaDTO estadisticaPreguntaDTO = new EstadisticaPreguntaDTO();
            estadisticaPreguntaDTO.setPreguntaId(pregunta.getId());
            estadisticaPreguntaDTO.setContenidoPregunta(pregunta.getContenido());
            estadisticaPreguntaDTO.setCantidadTotalRespuestas(cantidadRespuestas);

            estadisticaPreguntaDTOs.add(estadisticaPreguntaDTO);
        }

        estadisticas.setEstadisticasPreguntas(estadisticaPreguntaDTOs);
        return estadisticas;
        
    }

    public List<Respuesta> getRespuestasHoy(){
        return respuestaRepository.findByFechaRespuesta(LocalDateTime.now());
    }

    public List<Respuesta> getRespuestasByFechas(LocalDateTime inicio, LocalDateTime fechaFinal){
        return respuestaRepository.findByFechaRespuestaBetween(inicio, fechaFinal);
    }

}
