package com.frc.utn.edu.encuestas.encuestas.DTOs.Estadisticas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticaPreguntaDTO {
    private Long preguntaId;
    private String contenidoPregunta;
    private Long cantidadTotalRespuestas;
}
