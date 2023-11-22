package edu.palermo.revision.vehicular.microservicio.Controllers;

import edu.palermo.revision.vehicular.microservicio.Models.*;
import edu.palermo.revision.vehicular.microservicio.Models.Requests.RegistroEvaluadorRequest;
import edu.palermo.revision.vehicular.microservicio.Services.EvaluadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("evaluadores")
@Validated
public class EvaluadorController {

    @Autowired
    EvaluadorService evaluadorService;



    @PostMapping("/alta")
    public ResponseEntity<String> altaDueno(@RequestBody @Valid RegistroEvaluadorRequest request){

        UsuarioModel usuario = request.getUsuario();
        EvaluadorModel evaluador = request.getEvaluador();

        evaluadorService.altaDueno(usuario, evaluador);

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
