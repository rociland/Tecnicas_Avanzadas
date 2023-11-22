package edu.palermo.revision.vehicular.microservicio.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    @NotBlank(message = "El campo no puede ser vacio")
    @Email(message = "El formato del correo electrónico no es válido")
    private String correo;

    @Column
    @NotBlank(message = "El campo no puede ser vacio")
    private String contrasena;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private DuenoModel duenoVehiculo;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private EvaluadorModel evaluador;
}
