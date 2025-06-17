package com.frc.utn.edu.encuestas.encuestas.repositories;

import com.frc.utn.edu.encuestas.encuestas.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
}
