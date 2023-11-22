package edu.palermo.revision.vehicular.microservicio.Models.Requests;

import edu.palermo.revision.vehicular.microservicio.Models.EvaluadorModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import lombok.Data;

import javax.validation.Valid;

@Data
public class RegistroEvaluadorRequest {
    @Valid
    private UsuarioModel usuario;
    @Valid
    private EvaluadorModel evaluador;

}
