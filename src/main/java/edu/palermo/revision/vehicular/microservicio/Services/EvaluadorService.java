package edu.palermo.revision.vehicular.microservicio.Services;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.EvaluadorModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import edu.palermo.revision.vehicular.microservicio.Repositories.IEvaluadorRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvaluadorService {

    @Autowired
    IEvaluadorRepository evaluadorRepository;
    @Autowired
    IUsuarioRepository usuarioRepository;


    @Transactional
    public void altaDueno(UsuarioModel usuario, EvaluadorModel evaluador) {
        if(!usuarioRepository.existsByCorreo(usuario.getCorreo())){
            UsuarioModel usuarioGuardado = usuarioRepository.save(usuario);
            evaluador.setUsuario(usuarioGuardado);
            evaluadorRepository.save(evaluador);
        }else{
            throw new DataIntegrityViolationException("Correo Duplicado");
        }
    }


}
