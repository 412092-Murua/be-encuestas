package com.frc.utn.edu.encuestas.encuestas.DTOs.Estadisticas;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasEncuestaDTO {
    private Long encuestaId;
    private String tituloEncuesta;
    private List<EstadisticaPreguntaDTO> estadisticasPreguntas;
}
