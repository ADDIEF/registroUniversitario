package com.universidad.repository;

import com.universidad.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    @EntityGraph(attributePaths = {"docente", "prerequisitos", "esPrerequisitoDe"})
    @Query("SELECT m FROM Materia m WHERE m.id = :id")
    Optional<Materia> findWithRelationsById(@Param("id") Long id);
     Optional<Materia> findByCodigoUnico(String codigoUnico);
}
