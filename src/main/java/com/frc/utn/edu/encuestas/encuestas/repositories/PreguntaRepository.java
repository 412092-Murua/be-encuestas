package com.frc.utn.edu.encuestas.encuestas.repositories;

import com.frc.utn.edu.encuestas.encuestas.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
