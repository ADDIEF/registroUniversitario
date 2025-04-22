package com.universidad.service;

import com.universidad.dto.EstudianteDTO;
import com.universidad.dto.MateriaDTO;
import com.universidad.model.Materia;
import java.util.List;
import java.util.Optional;

public interface IEstudianteService {

    /**
     * Obtiene todos los estudiantes.
     * @return Lista de EstudianteDTO.
     */
    List<EstudianteDTO> obtenerTodosLosEstudiantes();

    /**
     * Obtiene estudiantes activos.
     * @return Lista de EstudianteDTO activos.
     */
    List<EstudianteDTO> obtenerEstudianteActivo();

    /**
     * Obtiene un estudiante por su número de inscripción.
     * @param numeroInscripcion Número de inscripción.
     * @return EstudianteDTO encontrado.
     */
    EstudianteDTO obtenerEstudiantePorNumeroInscripcion(String numeroInscripcion);

    /**
     * Obtiene las materias de un estudiante por su ID (modo directo).
     * @param estudianteId ID del estudiante.
     * @return Lista de materias asociadas.
     */
    List<Materia> obtenerMateriasDeEstudiante(Long estudianteId);

    /**
     * Crea un nuevo estudiante.
     * @param estudianteDTO Datos del nuevo estudiante.
     * @return EstudianteDTO creado.
     */
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO);

    /**
     * Actualiza un estudiante existente.
     * @param id ID del estudiante a actualizar.
     * @param estudianteDTO Datos actualizados.
     * @return EstudianteDTO actualizado.
     */
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);

    // --------------------- Operaciones opcionales con Optional ---------------------

    /**
     * Obtiene los estudiantes inscritos en una materia (por nombre de la materia).
     * @param nombreMateria Nombre de la materia.
     * @return Lista de EstudianteDTO o vacío si no hay estudiantes.
     */
    Optional<List<EstudianteDTO>> obtenerEstudiantesPorMateria(String nombreMateria);

    /**
     * Obtiene las materias en las que está inscrito un estudiante por su ID.
     * @param idEstudiante ID del estudiante.
     * @return Lista de MateriaDTO o vacío si no hay materias.
     */
    Optional<List<MateriaDTO>> obtenerMateriasPorEstudiante(Long idEstudiante);

}
