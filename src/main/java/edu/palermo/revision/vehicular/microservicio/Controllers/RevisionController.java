package edu.palermo.revision.vehicular.microservicio.Controllers;

import edu.palermo.revision.vehicular.microservicio.Models.Requests.RegistroRevisionRequest;
import edu.palermo.revision.vehicular.microservicio.Services.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("revisiones")
public class RevisionController {
    @Autowired
    RevisionService revisionService;



    @PostMapping("/registrar/{idEvaluador}")
    public ResponseEntity<String> registrarRevision(@PathVariable int idEvaluador, @RequestBody RegistroRevisionRequest registroRevisionRequest){
        return revisionService.registrarRevision(idEvaluador, registroRevisionRequest.getMatricula(), registroRevisionRequest.getRevision().getGases(),registroRevisionRequest.getRevision().getDireccion(),registroRevisionRequest.getRevision().getFrenos(),registroRevisionRequest.getRevision().getNeumaticos(),registroRevisionRequest.getRevision().getSuspension(),registroRevisionRequest.getRevision().getAmortiguador(),registroRevisionRequest.getRevision().getLuz(),registroRevisionRequest.getRevision().getChasis());


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Registra la excepción
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }
}
