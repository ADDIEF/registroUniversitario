package com.universidad.controller; // Define el paquete al que pertenece esta clase

import com.universidad.dto.EstudianteDTO; // Importa la clase EstudianteDTO del paquete dto
import com.universidad.model.Materia;
import com.universidad.service.IEstudianteService; // Importa la interfaz IEstudianteService del paquete service
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired de Spring
import org.springframework.http.ResponseEntity; // Importa la clase ResponseEntity de Spring para manejar respuestas HTTP
import org.springframework.http.HttpStatus; // Importa la clase HttpStatus de Spring para manejar códigos de estado HTTP
import org.springframework.web.bind.annotation.*; // Importa las anotaciones de Spring para controladores web

import java.util.List; // Importa la interfaz List para manejar listas
import java.util.Optional; // Importamos Optional
import java.util.Map; // Importamos Map para mandar respuestas personalizadas
import java.util.Collections;

@RestController // Anotación que indica que esta clase es un controlador REST de Spring
@RequestMapping("/api/estudiantes") // Define la ruta base para las solicitudes HTTP a este controlador
public class EstudianteController { // Define la clase EstudianteController

    private final IEstudianteService estudianteService; // Declara una variable final para el servicio de estudiantes

    @Autowired // Anotación que indica que el constructor debe ser usado para inyección de dependencias
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService; // Asigna el servicio de estudiantes a la variable de instancia
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes() {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/inscripcion/{numeroInscripcion}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorNumeroInscripcion(@PathVariable String numeroInscripcion) {
        EstudianteDTO estudiante = estudianteService.obtenerEstudiantePorNumeroInscripcion(numeroInscripcion);
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping("/{id}/materias")
    public ResponseEntity<List<Materia>> obtenerMateriasDeEstudiante(@PathVariable("id") Long estudianteId) {
        List<Materia> materias = estudianteService.obtenerMateriasDeEstudiante(estudianteId);
        return ResponseEntity.ok(materias);
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO nuevoEstudiante = estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.status(201).body(nuevoEstudiante);
    }

    @PutMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteDTO);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<EstudianteDTO>> obtenerEstudianteActivo() {
        List<EstudianteDTO> estudiantesActivos = estudianteService.obtenerEstudianteActivo();
        return ResponseEntity.ok(estudiantesActivos);
    }

    // ------------ tarea grupo: obtener estudiantes por nombre de materia
    @GetMapping("/materia/{nombreMateria}")
public ResponseEntity<?> obtenerEstudiantesPorMateria(@PathVariable String nombreMateria) {
    Optional<List<EstudianteDTO>> estudiantesOpt = estudianteService.obtenerEstudiantesPorMateria(nombreMateria);

    if (estudiantesOpt.isPresent() && !estudiantesOpt.get().isEmpty()) {
        return ResponseEntity.ok(estudiantesOpt.get());
    } else {
        String mensaje = "No se encontraron estudiantes para la materia " + nombreMateria;
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(Collections.singletonMap("mensaje", mensaje));
    }
}

}
