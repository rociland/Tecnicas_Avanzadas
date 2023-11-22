package edu.palermo.revision.vehicular.microservicio.Services;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.TurnoModel;
import edu.palermo.revision.vehicular.microservicio.Models.VehiculoModel;
import edu.palermo.revision.vehicular.microservicio.Repositories.ITurnoRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class TurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private IVehiculoRepository vehiculoRepository;

    public List<TurnoModel> getTurnos(){

        return turnoRepository.findByConfirmado(false);
    }

    public void registrarTurno(int idTurno, String matricula){
        TurnoModel turno = turnoRepository.findByID(idTurno);
        VehiculoModel vehiculoModel = vehiculoRepository.findByMatricula(matricula);

        turno.setVehiculo(vehiculoModel);
        turnoRepository.save(turno);
    }

    public void confirmarTurno(int id){
        TurnoModel turno = turnoRepository.findByID(id);
        turno.setConfirmado(true);
        turnoRepository.save(turno);
    }
}
