package com.bustos.rocio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bustos.rocio.model.Incidencia;
import com.bustos.rocio.service.IncidenciaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@RequestMapping("api/v1/incidencias")
public class IncidenciaController {
    @Autowired
    private IncidenciaService incidenciaService;
    @GetMapping
    public List<Incidencia> getIncidencias(){
        return incidenciaService.verIncidencias();
    }
    
    @PostMapping
    public Incidencia postIncidencia(@Valid @RequestBody Incidencia i){
        return incidenciaService.crearIncidencia(i);
    }

    @PutMapping("actualizar/{id}")
    public String updateIncidencia(@PathVariable int id, @RequestBody Incidencia incidenciaActualizada){
        return incidenciaService.actualizarIncidencia(id, incidenciaActualizada);
    }

    @GetMapping("buscar/{id}")
    public Incidencia searchIncidencia(@PathVariable int id){
        return incidenciaService.buscarIncidencia(id);
    }
    
    @DeleteMapping("eliminar/{id}")
    public String deteleIncidencia(@PathVariable int id){
        return incidenciaService.eliminarIncidencia(id);
    }

    //Busqueda especifica pendiente

}
