package com.frc.utn.edu.encuestas.encuestas.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encuesta_id")
    private Encuesta encuesta;
}
