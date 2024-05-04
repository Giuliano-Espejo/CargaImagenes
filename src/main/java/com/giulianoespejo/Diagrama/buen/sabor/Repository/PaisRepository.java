package com.giulianoespejo.Diagrama.buen.sabor.Repository;

import com.giulianoespejo.Diagrama.buen.sabor.Entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
