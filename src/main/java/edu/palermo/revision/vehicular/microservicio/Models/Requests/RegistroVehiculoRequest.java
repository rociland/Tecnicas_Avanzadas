package edu.palermo.revision.vehicular.microservicio.Models.Requests;

import lombok.Data;

import javax.validation.Valid;

@Data
public class RegistroVehiculoRequest {

    @Valid
    private String correoDueno;
    @Valid
    private String matricula;
    @Valid
    private String color;
    @Valid
    private String modelo;
}
