package edu.palermo.revision.vehicular.microservicio.Models.Requests;

import edu.palermo.revision.vehicular.microservicio.Models.RevisionModel;
import lombok.Data;

@Data
public class RegistroRevisionRequest {
    private String matricula;
    private RevisionModel revision;
}
