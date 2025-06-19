package com.frc.utn.edu.encuestas.encuestas.repositories;

import com.frc.utn.edu.encuestas.encuestas.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;


@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    Long countByPreguntaId(Long id);

    List<Respuesta> findByFechaRespuestaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFinal);
    List<Respuesta> findByFechaRespuesta(LocalDateTime fechaRespuesta);
}
