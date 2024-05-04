package com.giulianoespejo.Diagrama.buen.sabor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Sucursal extends Base{

    private String nombre;

    private LocalTime horarioApertura;

    private  LocalTime horarioCierre;

    @OneToOne
    private Domicilio domicilio;
}
