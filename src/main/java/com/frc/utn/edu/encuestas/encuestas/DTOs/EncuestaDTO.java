package com.frc.utn.edu.encuestas.encuestas.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EncuestaDTO {
    private Long id;
    private String titulo;
}
