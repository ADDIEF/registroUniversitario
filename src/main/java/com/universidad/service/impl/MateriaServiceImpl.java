package com.universidad.service.impl;

import com.universidad.model.Materia;
import com.universidad.repository.DocenteRepository;
import com.universidad.repository.MateriaRepository;
import com.universidad.service.IMateriaService;
import com.universidad.dto.MateriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//---------------------------------------------------------------
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.universidad.model.Docente;



import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaServiceImpl implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;
//------------------------------------- NUEVO-PRACTICA -------------------------------------
    // Método utilitario para mapear Materia a MateriaDTO
    private MateriaDTO mapToDTO(Materia materia) {
    if (materia == null) return null;
    return MateriaDTO.builder()
        .id(materia.getId())
        .nombreMateria(materia.getNombreMateria())
        .codigoUnico(materia.getCodigoUnico())
        .creditos(materia.getCreditos())
        .docenteId(materia.getDocente() != null ? materia.getDocente().getId() : null)
        .nombre_Docente(materia.getDocente() != null ? materia.getDocente().getNombre() : null)
        .apellido_Docente(materia.getDocente() != null ? materia.getDocente().getApellido() : null)
        .departamento_Docente(materia.getDocente() != null ? materia.getDocente().getDepartamento() : null)
        .prerequisitos(materia.getPrerequisitos() != null ?
            materia.getPrerequisitos().stream().map(Materia::getId).collect(Collectors.toList()) : null)
        .esPrerequisitoDe(materia.getEsPrerequisitoDe() != null ?
            materia.getEsPrerequisitoDe().stream().map(Materia::getId).collect(Collectors.toList()) : null)
        .build();
    }
//------------------------------------- NUEVO-PRACTICA -------------------------------------

    @Override
    @Cacheable(value = "materias")
    public List<MateriaDTO> obtenerTodasLasMaterias() {
        return materiaRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
//---------------------------------- NUEVO-practica -------------------------------------
    @Override
    @Transactional(readOnly = true)
    public MateriaDTO obtenerMateriaPorId(Long id) {
        Materia materia = materiaRepository.findWithRelationsById(id)
            .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID " + id));
        return mapToDTO(materia); // ✅ Llamada correcta al mapper manual
    }





// ----------------------------------- NUEVO-practica ----------------------------------|

    @Override
    @Cacheable(value = "materia", key = "#codigoUnico")
    public MateriaDTO obtenerMateriaPorCodigoUnico(String codigoUnico) {
    Materia materia = materiaRepository.findByCodigoUnico(codigoUnico)
        .orElseThrow(() -> new RuntimeException("Materia no encontrada con código: " + codigoUnico));
        return mapToDTO(materia);
    }

    @Override
    @CachePut(value = "materia", key = "#result.id")
    @CacheEvict(value = "materias", allEntries = true)
    public MateriaDTO crearMateria(MateriaDTO materiaDTO) {
        Materia materia = new Materia();
        materia.setNombreMateria(materiaDTO.getNombreMateria());
        materia.setCodigoUnico(materiaDTO.getCodigoUnico());
        materia.setCreditos(materiaDTO.getCreditos());

        if (materiaDTO.getDocenteId() != null) {
            Docente docente = docenteRepository.findById(materiaDTO.getDocenteId())
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
            materia.setDocente(docente);
        }


        Materia savedMateria = materiaRepository.save(materia);
        return mapToDTO(savedMateria);
    }

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    @Transactional
    @CachePut(value = "materia", key = "#id")
    @CacheEvict(value = "materias", allEntries = true)
    public MateriaDTO actualizarMateria(Long id, MateriaDTO materiaDTO) {
        Materia materia = materiaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Materia not found"));

        materia.setNombreMateria(materiaDTO.getNombreMateria());
        materia.setCodigoUnico(materiaDTO.getCodigoUnico());
        materia.setCreditos(materiaDTO.getCreditos());

        if (materiaDTO.getDocenteId() != null) {
        Docente docente = docenteRepository.findById(materiaDTO.getDocenteId())
            .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        materia.setDocente(docente);
}


        Materia updatedMateria = materiaRepository.save(materia);
        return mapToDTO(updatedMateria);
    }

    @Override
    @CacheEvict(value = {"materia", "materias"}, allEntries = true)
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }
}
