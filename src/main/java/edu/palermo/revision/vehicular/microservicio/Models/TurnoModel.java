package edu.palermo.revision.vehicular.microservicio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "turnos")
public class TurnoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private String hora;

    @Column
    private String fecha;

    @Column
    private boolean confirmado;

    @OneToOne
    @JoinColumn(name = "id_vehiculo")
    private VehiculoModel vehiculo;

}
