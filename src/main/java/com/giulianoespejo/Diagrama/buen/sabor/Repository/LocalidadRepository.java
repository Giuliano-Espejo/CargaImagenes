package com.giulianoespejo.Diagrama.buen.sabor.Repository;

import com.giulianoespejo.Diagrama.buen.sabor.Entity.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad,Long> {
}
