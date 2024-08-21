package com.saldoya.prueba.Prueba.Controller;

import com.saldoya.prueba.Prueba.Model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWordController {
    @GetMapping("/")
    public String helloWord() {
        return "Spring Boot es una herramienta para desarrollar APIs en Java";
    }
    @GetMapping("/hello/{name}")
    public String helllo(@PathVariable String name){
        return "Hello "+name;
    }
    @GetMapping("/bye/{name}")
    public String bye(@PathVariable String name){
        return "Goodbye "+name;
    }
    @GetMapping("/suma/{a}/{b}")
    public int suma(@PathVariable int a, @PathVariable int b){
        return a+b;
    }
    @GetMapping("/imc")
    public String calcularimc(@RequestParam Double imc){
        if(imc<18.5){
            return "peso insuficiente";
        }
        if(imc<24.9){
            return "peso normal";
        }
        if(imc<29.9){
            return "Sobrepeso";
        }
        return "Obesidad";
    }
    @GetMapping("/galones-litro")
    public String galonesALitro(@RequestParam Double galones){
        Double litros = galones/3.78541;
        return "La cantidad de litros es : " + litros;
    }

    @PostMapping("/cliente")
    public void salvarCliente(@RequestBody Cliente cli){
        System.out.println("Salvando Cliente");
        System.out.println(cli.toString());
    }

    @GetMapping("/cliente/traer")
    @ResponseBody
    public List<Cliente> getClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "tobias", "jensen"));
        clientes.add(new Cliente(2, "Milei", "Milei"));
        clientes.add(new Cliente(3, "Juan", "Juan"));
        clientes.add(new Cliente(4, "Tio", "Maicol"));
        return clientes;
    }

    @GetMapping("/response-status")
    ResponseEntity<String> responseStatus(){
        return new ResponseEntity<>("Esta todo ok", HttpStatus.OK);
    }

}
