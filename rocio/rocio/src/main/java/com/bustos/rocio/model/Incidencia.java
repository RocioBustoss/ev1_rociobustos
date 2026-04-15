package com.bustos.rocio.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Incidencia {
    private static AtomicInteger counter = new AtomicInteger(100);
    private int id;

    @NotNull(message = "La descripcion es necesaria")
    @NotBlank(message = "La descripción no debe estar vacia")
    private String descripcion;

    @NotNull(message = "El estado es obligatorio")
    @NotBlank(message = "El estado no debe estar vacio")
    private String estado;

    @NotNull(message = "El nivel de prioridad es necesario")
    @NotBlank(message = "el nivel no debe estar vacio")
    @Max(value = 3, message = "El nivel maximo es 3")
    @Min(value = 1, message = "El nivel minimo es 1")
    private int nivelPrioridad;

    @NotNull(message = "El nombre de usuario es obligatorio")
    @NotBlank(message = "El nombre no debe estar vacio")
    @Size( min = 1, max = 50, message = "El nombre debe contener entre 1 y 50 caracteres")
    private String usuario;

    private LocalDateTime fechaRegistro;


    public Incidencia (String descripcion, String estado, int nivelPrioridad, String usuario){
        this.id = counter.getAndIncrement();
        this.descripcion = descripcion;
        this.estado = estado;
        this.nivelPrioridad = nivelPrioridad;
        this.usuario = usuario;
        this.fechaRegistro = LocalDateTime.now();
    }
}
