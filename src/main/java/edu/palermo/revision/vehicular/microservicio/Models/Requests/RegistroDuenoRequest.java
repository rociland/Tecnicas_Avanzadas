package edu.palermo.revision.vehicular.microservicio.Models.Requests;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import lombok.Data;

import javax.validation.Valid;

@Data
public class RegistroDuenoRequest {
    @Valid
    private UsuarioModel usuario;
    @Valid
    private DuenoModel dueno;

}
