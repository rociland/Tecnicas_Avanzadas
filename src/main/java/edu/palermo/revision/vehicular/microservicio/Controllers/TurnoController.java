package edu.palermo.revision.vehicular.microservicio.Controllers;

import edu.palermo.revision.vehicular.microservicio.Models.Requests.RegistroTurnoRequest;
import edu.palermo.revision.vehicular.microservicio.Models.TurnoModel;
import edu.palermo.revision.vehicular.microservicio.Services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turnos")
public class TurnoController {
    @Autowired
    TurnoService turnoService;

    @GetMapping("/")
    public List<TurnoModel> getAllTurnos(){
        return turnoService.getTurnos();
    }

    @PutMapping ("/turnoRegistro/{id}")
    public ResponseEntity<String> registrarTurno(@PathVariable int id, @RequestBody RegistroTurnoRequest registroTurnoRequest){
        turnoService.registrarTurno(id,registroTurnoRequest.getMatricula());
        return ResponseEntity.ok("ok");
    }

    @PutMapping ("/confirmar/{id}")
    public ResponseEntity<String> confirmarTurno(@PathVariable int id){
        turnoService.confirmarTurno(id);
        return ResponseEntity.ok("ok");
    }

}
