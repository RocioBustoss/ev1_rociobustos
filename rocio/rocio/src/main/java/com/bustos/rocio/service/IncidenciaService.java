package com.bustos.rocio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bustos.rocio.model.Incidencia;
import com.bustos.rocio.repository.IncidenciaRepository;


@Service
public class IncidenciaService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;
    public List<Incidencia> verIncidencias(){
        return incidenciaRepository.leerIncidencias();
    }
    public Incidencia crearIncidencia(Incidencia i) {
        return incidenciaRepository.agregarIncidencia(i);
    }
    public String actualizarIncidencia(int id, Incidencia incidenciaActualizada) {
        return incidenciaRepository.modificarIncidencia(id, incidenciaActualizada);
    }
    public Incidencia buscarIncidencia(int id) {
        return incidenciaRepository.encontrarIncidencia(id);
    }
    public String eliminarIncidencia(int id) {
        return incidenciaRepository.quitarIncidencia(id);
    }
    
}
