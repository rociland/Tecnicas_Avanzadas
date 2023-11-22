package edu.palermo.revision.vehicular.microservicio.Services;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import edu.palermo.revision.vehicular.microservicio.Repositories.IDuenoRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DuenoService {

    @Autowired
    IDuenoRepository duenoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Transactional
    public void altaDueno(UsuarioModel usuario, DuenoModel dueno) {
        if(!usuarioRepository.existsByCorreo(usuario.getCorreo())){
            UsuarioModel usuarioGuardado = usuarioRepository.save(usuario);
            dueno.setUsuario(usuarioGuardado);
            duenoRepository.save(dueno);
        }else{
            throw new DataIntegrityViolationException("Usuario existente");
        }
    }

    public List<DuenoModel> getAll(){
        return duenoRepository.findAll();
    }

}
