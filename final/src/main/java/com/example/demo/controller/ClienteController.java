package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "Cliente creado correctamente";
    }

    @DeleteMapping("/eliminar/{idCLiente}")
    public String eliminarCliente(@RequestAttribute Long idCliente) {
        clienteService.eliminarCliente(idCliente);
        return "Cliente eliminado correctamente";
    }

    @PutMapping("/editar")
    public String editarCliente(@RequestBody Cliente cliente) {
        clienteService.actualizarCliente(cliente);
        return "Cliente editado correctamente";
    }

    @GetMapping()
    public List<Cliente> listarClientes() {
        return clienteService.listarCliente();
    }

    @GetMapping("/{idCliente}")
    public Cliente buscarClientePorId(@RequestAttribute Long idCliente) {
        return clienteService.buscarClientePorId(idCliente);
    }


}
