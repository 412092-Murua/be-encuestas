package com.frc.utn.edu.encuestas.encuestas.services;

import com.frc.utn.edu.encuestas.encuestas.entities.Pregunta;
import com.frc.utn.edu.encuestas.encuestas.repositories.PreguntaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    @GetMapping("/preguntas")
    public List<Pregunta> getAllPreguntas() {
        return preguntaRepository.findAll();
    }

    @GetMapping("/preguntas/{id}")
    public Pregunta getPreguntaById(Long id) {
        return preguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pregunta con id " + id + " no encontrada"));
    }

    @PostMapping("/preguntas")
    public Pregunta postPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @DeleteMapping("/preguntas/{id}")
    public void deletePregunta(@PathVariable Long id) {
        if (!preguntaRepository.existsById(id)) {
            throw new RuntimeException("Pregunta con id " + id + " no encontrada");
        }
        preguntaRepository.deleteById(id);
    }
}
