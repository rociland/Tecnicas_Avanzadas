package edu.palermo.revision.vehicular.microservicio.Services;

import edu.palermo.revision.vehicular.microservicio.Models.EvaluadorModel;
import edu.palermo.revision.vehicular.microservicio.Models.RevisionModel;
import edu.palermo.revision.vehicular.microservicio.Models.VehiculoModel;
import edu.palermo.revision.vehicular.microservicio.Repositories.IEvaluadorRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IRevisionRepository;
import edu.palermo.revision.vehicular.microservicio.Repositories.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RevisionService {

    @Autowired
    IRevisionRepository revisionRepository;
    @Autowired
    IEvaluadorRepository evaluadorRepository;
    @Autowired
    IVehiculoRepository vehiculoRepository;

    public ResponseEntity<String> registrarRevision(int idEvaluador, String matricula, int gases, int direccion, int frenos, int neumaticos, int suspension, int amortiguador, int luz, int chasis ){
        EvaluadorModel evaluador = evaluadorRepository.findById(idEvaluador);
        VehiculoModel vehiculo = vehiculoRepository.findByMatricula(matricula);

        RevisionModel revision = new RevisionModel();
        revision.setGases(gases);
        revision.setDireccion(direccion);
        revision.setFrenos(frenos);
        revision.setNeumaticos(neumaticos);
        revision.setSuspension(suspension);
        revision.setAmortiguador(amortiguador);
        revision.setLuz(luz);
        revision.setChasis(chasis);
        revision.setCalificacion(this.calcularTotal(revision));
        revision.setEvaluador(evaluador);
        revision.setVehiculo(vehiculo);

        revisionRepository.save(revision);

        return this.evaluacionFinal(revision);

    }

    public int calcularTotal(RevisionModel revision){
        return revision.getChasis() + revision.getLuz() + revision.getAmortiguador()+ revision.getSuspension()+revision.getNeumaticos()+revision.getFrenos()+revision.getDireccion()+revision.getGases();
    }

    public ResponseEntity<String> evaluacionFinal(RevisionModel revision){
        int total = this.calcularTotal(revision);
        String mensaje = null;


        if(total >= 80){
            mensaje = "Su vehiculo es seguro";
        }else if(total <= 40){
             mensaje = "Su vehiculo es necesita rechequeo";
        }else if(revision.getChasis() >=5 ||  revision.getLuz() >=5 || revision.getAmortiguador() >=5 || revision.getSuspension() >=5 || revision.getNeumaticos() >=5 || revision.getFrenos() >=5 || revision.getDireccion() >=5 || revision.getGases()>=5 ){
            mensaje = "Su vehiculo es necesita rechequeo";
        }
        return ResponseEntity.ok(mensaje);

    }
}
