package com.universidad.service;

import com.universidad.dto.InscripcionDTO;
import java.util.List;

public interface IInscripcionService {
    InscripcionDTO crearInscripcion(InscripcionDTO dto);
    List<InscripcionDTO> obtenerTodas();
    InscripcionDTO obtenerPorId(Long id);
    void eliminarInscripcion(Long id);
}
