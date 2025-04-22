package com.universidad.repository;

import com.universidad.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Estudiante findByNumeroInscripcion(String numeroInscripcion);

    Estudiante findByEstado(String estado);

    // ---------- tarea grupo: buscamos por nombreMateria, no nombre
    Optional<List<Estudiante>> findByMateriasNombreMateria(String nombreMateria);
}
