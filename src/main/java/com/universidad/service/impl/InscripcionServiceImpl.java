package com.universidad.service.impl;

import com.universidad.dto.InscripcionDTO;
import com.universidad.model.Estudiante;
import com.universidad.model.Materia;
import com.universidad.model.Inscripcion;
import com.universidad.repository.EstudianteRepository;
import com.universidad.repository.MateriaRepository; // <-- ESTA ES LA QUE FALTA
import com.universidad.repository.InscripcionRepository;
import com.universidad.service.IInscripcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// ------------------------ NUEVO practica ------------------------

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;




@Service
public class InscripcionServiceImpl implements IInscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MateriaRepository materiaRepository;
// aqui tenemos los mapeos de los dtos 
    private InscripcionDTO mapToDTO(Inscripcion inscripcion) {
    return InscripcionDTO.builder()
            .id(inscripcion.getId())
            .estudianteId(inscripcion.getEstudiante().getId())
            .nombreEstudiante(inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getApellido()) // NUEVO
            .materiaId(inscripcion.getMateria().getId())
            .nombreMateria(inscripcion.getMateria().getNombreMateria()) // NUEVO
            .fechaInscripcion(inscripcion.getFechaInscripcion())
            .estado(inscripcion.getEstado())
            .build();
}


    @Override
    @Transactional
    public InscripcionDTO crearInscripcion(InscripcionDTO dto) {
        Optional<Inscripcion> existente = inscripcionRepository.findByEstudianteIdAndMateriaId(dto.getEstudianteId(), dto.getMateriaId());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una inscripción para este estudiante y materia.");
        }

        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));

       Materia materia = entityManager.createQuery(
            "SELECT m FROM Materia m WHERE m.id = :id", Materia.class)
            .setParameter("id", dto.getMateriaId())
            .setHint("org.hibernate.readOnly", true)
            .getSingleResult();


        Inscripcion nueva = Inscripcion.builder()
                .estudiante(estudiante)
                .materia(materia)
                .fechaInscripcion(dto.getFechaInscripcion() != null ? dto.getFechaInscripcion() : LocalDate.now())
                .estado(dto.getEstado() != null ? dto.getEstado() : "Inscrito")
                .build();

        return mapToDTO(inscripcionRepository.save(nueva));
    }

    @Override
    public List<InscripcionDTO> obtenerTodas() {
        return inscripcionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InscripcionDTO obtenerPorId(Long id) {
        return inscripcionRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IllegalArgumentException("Inscripción no encontrada"));
    }

    @Override
    public void eliminarInscripcion(Long id) {
        if (!inscripcionRepository.existsById(id)) {
            throw new IllegalArgumentException("Inscripción no encontrada");
        }
        inscripcionRepository.deleteById(id);
    }
// ------------------------ NUEVO practica ------------------------
    @PersistenceContext
    private EntityManager entityManager;

}
