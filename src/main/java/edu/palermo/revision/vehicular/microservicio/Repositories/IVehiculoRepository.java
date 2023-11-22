package edu.palermo.revision.vehicular.microservicio.Repositories;

import edu.palermo.revision.vehicular.microservicio.Models.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository  extends JpaRepository<VehiculoModel, Integer> {
    VehiculoModel findByMatricula(String matricula);
}
