package edu.palermo.revision.vehicular.microservicio.Controllers;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.Requests.RegistroDuenoRequest;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import edu.palermo.revision.vehicular.microservicio.Services.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/duenos")
@Validated
public class DuenoController {

    @Autowired
    DuenoService duenoService;

    @GetMapping("/")
    public List<DuenoModel> getAll() {
        return duenoService.getAll();
    }

    @PostMapping("/alta")
    public ResponseEntity<String> altaDueno(@RequestBody @Valid RegistroDuenoRequest request){

        UsuarioModel usuario = request.getUsuario();
        DuenoModel dueno = request.getDueno();

        duenoService.altaDueno(usuario, dueno);

        return ResponseEntity.ok("Registro exitoso");

    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        String mensajeError = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body("Error de validación: " + mensajeError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body("El correo ya está registrado");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body("Error general: " + e.getMessage());
    }


}
