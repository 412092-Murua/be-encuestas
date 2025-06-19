package com.frc.utn.edu.encuestas.encuestas.DTOs;

import java.util.List;

import com.frc.utn.edu.encuestas.encuestas.entities.Respuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTO {
    private Long encuestaId;
    private List<Respuesta> respuestas;
}
