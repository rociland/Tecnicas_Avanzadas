package edu.palermo.revision.vehicular.microservicio.Services;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import edu.palermo.revision.vehicular.microservicio.Models.VehiculoModel;
import edu.palermo.revision.vehicular.microservicio.Repositories.IDuenoRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IUsuarioRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class VehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Autowired
    IDuenoRepository duenoRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity<String> altaVehiculo(String correo, String matricula, String color, String modelo){
        UsuarioModel usuario = usuarioRepository.findByCorreo(correo);
        if(usuario != null){


                VehiculoModel vehiculo = new VehiculoModel();
                vehiculo.setMatricula(matricula);
                vehiculo.setColor(color);
                vehiculo.setModelo(modelo);
                vehiculo.setDueno(usuario.getDuenoVehiculo());
                vehiculoRepository.save(vehiculo);

                return ResponseEntity.ok("Vehiculo dado de alta correctamente");
        }else{
            return ResponseEntity.badRequest().build();
        }



    }
}
