package edu.palermo.revision.vehicular.microservicio.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="Vehiculos")
public class VehiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @NotBlank(message = "No puede contener campos vacios")
    @Column
    private String matricula;

    @NotBlank(message = "No puede contener campos vacios")
    @Column
    private String color;

    @NotBlank(message = "No puede contener campos vacios")
    @Column
    private String modelo;

    @OneToOne
    @JoinColumn(name = "id_dueno")
    private DuenoModel dueno;

    @OneToOne(mappedBy = "vehiculo")
    @JsonIgnore
    private TurnoModel turno;

    @OneToOne(mappedBy = "vehiculo")
    @JsonIgnore
    private RevisionModel revision;



}
