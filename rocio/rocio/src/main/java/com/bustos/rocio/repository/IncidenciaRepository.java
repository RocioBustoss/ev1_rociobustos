package com.bustos.rocio.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bustos.rocio.model.Incidencia;
@Repository
public class IncidenciaRepository {
    private List<Incidencia> listaIncidencias = new ArrayList<>();
    public List<Incidencia> leerIncidencias(){
        return listaIncidencias;
    }
    public Incidencia agregarIncidencia(Incidencia i) {
        listaIncidencias.add(i);
        return i;
    }
    public String modificarIncidencia(int id, Incidencia incidenciaActualizada) {
        for (Incidencia incidencia : listaIncidencias) {
            if(incidencia.getId() == id){
                incidencia.setDescripcion(incidenciaActualizada.getDescripcion());
                incidencia.setEstado(incidenciaActualizada.getEstado());
                incidencia.setNivelPrioridad(incidenciaActualizada.getNivelPrioridad());
                incidencia.setUsuario(incidenciaActualizada.getUsuario());
                incidencia.setFechaRegistro(incidenciaActualizada.getFechaRegistro());
                return id+" Actualizada";
            }
        }
        return id+" No encontrada";
    }
    public Incidencia encontrarIncidencia(int id) {
        for (Incidencia incidencia : listaIncidencias) {
            if(incidencia.getId() == id){
                return incidencia;
            }
        }
        return null;
    }
    public String quitarIncidencia(int id) {
        for (Incidencia incidencia : listaIncidencias) {
            if(incidencia.getId() == id){
                listaIncidencias.remove(incidencia);
                return id+" Eliminada";
            }
        }
        return id+" No encontrada";
    }


}
