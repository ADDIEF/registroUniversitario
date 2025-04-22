package com.universidad.repository;

import com.universidad.model.Estudiante;
import com.universidad.model.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Estudiante findByNumeroInscripcion(String numeroInscripcion);

    Estudiante findByEstado(String estado);

    // ---------- tarea grupo: buscamos por nombreMateria, no nombre
    Optional<List<Estudiante>> findByMateriasNombreMateria(String nombreMateria);
    
    //--------------------------------------buscar por ids---------------------------------------------
    @Query("SELECT m FROM Estudiante e JOIN e.materias m WHERE e.id = :idEstudiante AND m IS NOT NULL")
    Optional<List<Materia>> findMateriasByEstudianteId(@Param("idEstudiante") Long idEstudiante);

}
