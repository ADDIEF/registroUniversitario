package com.universidad.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MateriaDTO implements Serializable {

    private Long id;
// --------------------- Verificaciones de seguridad -----------------------------------
    @NotBlank(message = "El nombre de la materia es obligatorio")
    @Size(max = 100, message = "El nombre no debe superar los 100 caracteres")
    private String nombreMateria;

    @NotBlank(message = "El código único es obligatorio")
    private String codigoUnico;

    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "La materia debe tener al menos 1 crédito")
    private Integer creditos;

    /**
     * Lista de IDs de materias que son prerequisitos para esta materia.
     */
    private List<Long> prerequisitos;

    /**
     * Lista de IDs de materias para las que esta materia es prerequisito.
     */
    private List<Long> esPrerequisitoDe;

// --------------------------- nuevo-practica -------------------------------------------
    private Long docenteId; // ID del docente asignado
    private String nombre_Docente;
    private String apellido_Docente;
    private String departamento_Docente; // solo lo que queremos mostrar


}
