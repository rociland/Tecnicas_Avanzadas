package edu.palermo.revision.vehicular.microservicio.Repositories;

import edu.palermo.revision.vehicular.microservicio.Models.TurnoModel;
import edu.palermo.revision.vehicular.microservicio.Services.TurnoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<TurnoModel,Integer> {
    @Query("SELECT e FROM TurnoModel e WHERE e.confirmado = :valorCondicion")
    List<TurnoModel> findByConfirmado(@Param("valorCondicion") boolean valorCondicion);

    @Query("SELECT e FROM TurnoModel e WHERE e.ID = :valorCondicion")
    TurnoModel findByID(@Param("valorCondicion") int valorCondicion);
}
