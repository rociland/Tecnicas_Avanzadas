package edu.palermo.revision.vehicular.microservicio.Repositories;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenoRepository extends JpaRepository<DuenoModel, Integer> {
    DuenoModel findByUsuario(UsuarioModel usuario);

}
