package edu.palermo.revision.vehicular.microservicio.Repositories;

import edu.palermo.revision.vehicular.microservicio.Models.EvaluadorModel;
import edu.palermo.revision.vehicular.microservicio.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    boolean existsByCorreo(String email);
    UsuarioModel findByCorreo(String email);

}
