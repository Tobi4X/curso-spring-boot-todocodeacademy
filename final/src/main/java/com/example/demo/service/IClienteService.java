package com.example.demo.service;

import com.example.demo.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {
    void crearCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    List<Cliente> listarCliente();
    Cliente buscarClientePorId(Long id);
}
