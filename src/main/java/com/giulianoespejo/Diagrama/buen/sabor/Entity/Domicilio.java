package com.giulianoespejo.Diagrama.buen.sabor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Domicilio extends Base {

    private String calle;

    private Integer numero;

    private Integer piso;

    private Integer departamento;

    @ManyToOne
    private Localidad localidad;
}
