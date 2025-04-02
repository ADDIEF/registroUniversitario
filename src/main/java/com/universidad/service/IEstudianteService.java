package com.universidad.service; // Define el paquete al que pertenece esta interfaz

import com.universidad.dto.EstudianteDTO; // Importa la clase EstudianteDTO del paquete dto

import java.util.List; // Importa la interfaz List para manejar listas

public interface IEstudianteService { // Define la interfaz IEstudianteService
    
    List<EstudianteDTO> obtenerTodosLosEstudiantes(); // Método para obtener una lista de todos los EstudianteDTO
    
    //----------------------------- PRACTICA 1 --------------------------------------------
    // Crear un nuevo estudiante
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO);

    // Obtener estudiante por ID
    EstudianteDTO obtenerEstudiantePorId(Long id);

    // Actualizar estudiante
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);

    // Eliminar estudiante
    void eliminarEstudiante(Long id);
}