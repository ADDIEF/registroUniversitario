package com.universidad.repository; // Define el paquete al que pertenece esta clase

import com.universidad.model.Estudiante; // Importa la clase Estudiante del paquete model

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository; // Importa la anotación Repository de Spring

import java.time.LocalDate; // Importa la clase LocalDate para manejar fechas
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas
import java.util.List; // Importa la interfaz List para manejar listas
import java.util.Map; // Importa la interfaz Map para manejar mapas
import java.util.concurrent.ConcurrentHashMap; // Importa la clase ConcurrentHashMap para manejar mapas concurrentes
import java.util.concurrent.atomic.AtomicLong; // Importa la clase AtomicLong para manejar contadores atómicos

@Repository // Anotación que indica que esta clase es un repositorio de Spring
public class EstudianteRepository {
    private final Map<Long, Estudiante> estudiantes = new ConcurrentHashMap<>(); // Mapa concurrente para almacenar estudiantes con su ID como clave
    private final AtomicLong idContador = new AtomicLong(1); // Contador atómico para generar IDs únicos para los estudiantes
    
    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            estudiante.setId(idContador.getAndIncrement());
        }
        estudiantes.put(estudiante.getId(), estudiante); // Esto reemplaza si ya existe
        return estudiante;
    }
    
    
    public List<Estudiante> findAll() { // Método para obtener todos los estudiantes
        return new ArrayList<>(estudiantes.values()); // Retorna una lista de todos los estudiantes en el mapa
    }
    
    public void deleteById(Long id) { // Método para eliminar un estudiante por su ID
        estudiantes.remove(id); // Elimina el estudiante del mapa
    }
    
    // Método para inicializar algunos datos de ejemplo
    @PostConstruct
public void init() {
    if (estudiantes.isEmpty()) {
        Estudiante estudiante1 = Estudiante.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .email("juan.perez@example.com")
                .fechaNacimiento(LocalDate.of(2000, 5, 15))
                .numeroInscripcion("S001")
                .build();

        Estudiante estudiante2 = Estudiante.builder()
                .nombre("María")
                .apellido("González")
                .email("maria.gonzalez@example.com")
                .fechaNacimiento(LocalDate.of(2001, 8, 22))
                .numeroInscripcion("S002")
                .build();

        save(estudiante1);
        save(estudiante2);
    }
}


    //---------------------------------------- PRACTICA 1 --------------------------------
    public Estudiante findById(Long id) {
        System.out.println("Obteniendo estudiante con ID: " + id);

        return estudiantes.get(id); // Devuelve el estudiante si existe, sino null
    }
    
    public boolean existsById(Long id) {
        return estudiantes.containsKey(id); // Devuelve true si existe el ID en el mapa
    }
    
}