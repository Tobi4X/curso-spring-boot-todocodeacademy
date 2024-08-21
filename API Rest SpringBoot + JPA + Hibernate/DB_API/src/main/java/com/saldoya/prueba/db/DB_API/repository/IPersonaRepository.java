package com.saldoya.prueba.db.DB_API.repository;

import com.saldoya.prueba.db.DB_API.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long> {
}
