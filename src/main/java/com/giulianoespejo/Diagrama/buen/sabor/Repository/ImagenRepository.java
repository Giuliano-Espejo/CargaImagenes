package com.giulianoespejo.Diagrama.buen.sabor.Repository;

import com.giulianoespejo.Diagrama.buen.sabor.Entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen,Long> {
}
