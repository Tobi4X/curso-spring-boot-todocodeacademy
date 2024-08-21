package com.example.demo.service.cliente;

import com.example.demo.model.Cliente;
import com.example.demo.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        Cliente clienteActualizar = this.buscarClientePorId(cliente.getIdCLiente());
        clienteActualizar.setNombre(cliente.getNombre());
        clienteActualizar.setApellido(cliente.getApellido());
        clienteActualizar.setDni(cliente.getDni());
        clienteRepository.save(clienteActualizar);
    }

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
