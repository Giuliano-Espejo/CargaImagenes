package com.giulianoespejo.Diagrama.buen.sabor.Repository;

import com.giulianoespejo.Diagrama.buen.sabor.Entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
