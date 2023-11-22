package edu.palermo.revision.vehicular.microservicio.Services;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.EvaluadorModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import edu.palermo.revision.vehicular.microservicio.Repositories.IDuenoRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IEvaluadorRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    IDuenoRepository duenoRepository;
    @Autowired
    IEvaluadorRepository evaluadorRepository;


    public ResponseEntity<String>login(UsuarioModel usuario){

        UsuarioModel usuarioBD = usuarioRepository.findByCorreo(usuario.getCorreo());
        if(usuarioBD != null && usuarioBD.getContrasena().equals(usuario.getContrasena())){
            DuenoModel duenio = duenoRepository.findByUsuario(usuarioBD);
            if(duenio == null){
                EvaluadorModel evaluador = evaluadorRepository.findByUsuario(usuarioBD);
                return ResponseEntity.ok(evaluador.getNombre() + " "  + evaluador.getApellido());
            }else {
                return ResponseEntity.ok(duenio.getNombre() + " " + duenio.getApellido());
            }
        }else{
            return ResponseEntity.ok("Usuario o contraseña invalidos");
        }

    }



}
