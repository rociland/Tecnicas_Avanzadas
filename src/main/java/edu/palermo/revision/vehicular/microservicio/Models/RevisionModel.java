package edu.palermo.revision.vehicular.microservicio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Revision")
public class RevisionModel {
    @Id
    private int ID;
    @Column
    private int gases;
    @Column
    private int direccion;
    @Column
    private int frenos;
    @Column
    private int neumaticos;
    @Column
    private int suspension;
    @Column
    private int amortiguador;
    @Column
    private int luz;
    @Column
    private int chasis;
    @Column
    private int calificacion;

    @OneToOne
    @JoinColumn(name = "id_evaluador")
    private EvaluadorModel evaluador;

    @OneToOne
    @JoinColumn(name = "id_vehiculo")
    private VehiculoModel vehiculo;
}
