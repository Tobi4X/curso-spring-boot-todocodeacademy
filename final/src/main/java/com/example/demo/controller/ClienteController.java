package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "Cliente creado correctamente";
    }

    @DeleteMapping("/clientes/eliminar/{idCLiente}")
    public String eliminarCliente(@PathVariable Long idCliente) {
        clienteService.eliminarCliente(idCliente);
        return "Cliente eliminado correctamente";
    }

    @PutMapping("/clientes/editar")
    public String editarCliente(@RequestBody Cliente cliente) {
        clienteService.actualizarCliente(cliente);
        return "Cliente editado correctamente";
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteService.listarCliente();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente buscarClientePorId(@PathVariable Long idCliente) {
        return clienteService.buscarClientePorId(idCliente);
    }


}
