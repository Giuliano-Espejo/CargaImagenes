package com.giulianoespejo.Diagrama.buen.sabor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Empresa extends Base{

    private String nombre;

    private String razonSocial;

    private Integer cuil;

    @OneToMany
    @JoinColumn(name = "empresa_id")
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();
}
