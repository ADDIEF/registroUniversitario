package com.universidad.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "evaluacion_docente")
public class EvaluacionDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // mejor para rendimiento
    @JoinColumn(name = "docente_id", nullable = false)
    @JsonIgnore // 🔁 Evita bucle infinito en la serialización
    private Docente docente;

    @Column(nullable = false)
    private Integer puntaje;

    @Column(length = 255)
    private String comentario;

    @Column(name = "fecha_evaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

}
