package edu.palermo.revision.vehicular.microservicio.Controllers;


import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import edu.palermo.revision.vehicular.microservicio.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/duenos")
@Validated
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("login")
    public ResponseEntity<String>login(@RequestBody @Valid UsuarioModel usuario){
        return usuarioService.login(usuario);
    }


}
