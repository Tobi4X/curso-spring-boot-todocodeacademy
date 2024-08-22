package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
}
