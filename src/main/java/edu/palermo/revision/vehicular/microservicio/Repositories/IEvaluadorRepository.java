package edu.palermo.revision.vehicular.microservicio.Repositories;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.EvaluadorModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface IEvaluadorRepository extends JpaRepository<EvaluadorModel, Integer> {

    EvaluadorModel findByUsuario(UsuarioModel usuario);
    EvaluadorModel findById(int id);
}
