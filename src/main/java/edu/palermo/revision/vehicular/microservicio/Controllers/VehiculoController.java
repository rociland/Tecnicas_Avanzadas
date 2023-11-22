package edu.palermo.revision.vehicular.microservicio.Controllers;

import edu.palermo.revision.vehicular.microservicio.Models.Requests.RegistroVehiculoRequest;
import edu.palermo.revision.vehicular.microservicio.Services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("vehiculos")
@Validated
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @PostMapping("alta")
    public ResponseEntity<String> altaVehiculo(@RequestBody @Valid RegistroVehiculoRequest vehiculoRequest){
        return vehiculoService.altaVehiculo(vehiculoRequest.getCorreoDueno(), vehiculoRequest.getMatricula(),vehiculoRequest.getColor(),vehiculoRequest.getModelo());

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
