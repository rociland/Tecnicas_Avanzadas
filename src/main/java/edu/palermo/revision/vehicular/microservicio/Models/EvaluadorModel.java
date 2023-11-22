package edu.palermo.revision.vehicular.microservicio.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="evaluador")
public class EvaluadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank(message = "El campo no puede ser vacio")
    private String nombre;

    @Column
    @NotBlank (message = "El formato de mail no es valido")
    private String apellido;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioModel usuario;

    @OneToOne(mappedBy = "evaluador")
    @JsonIgnore
    private RevisionModel revision;


}
