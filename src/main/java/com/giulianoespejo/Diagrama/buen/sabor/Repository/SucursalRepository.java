package com.giulianoespejo.Diagrama.buen.sabor.Repository;

import com.giulianoespejo.Diagrama.buen.sabor.Entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
