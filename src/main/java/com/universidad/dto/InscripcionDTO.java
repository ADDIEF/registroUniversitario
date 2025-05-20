package com.universidad.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionDTO {
    private Long id;
    private Long estudianteId;
    private String nombreEstudiante;  // <-- datos aqui
    private Long materiaId;
    private String nombreMateria;     // <-- d a
    private LocalDate fechaInscripcion;
    private String estado;
}
