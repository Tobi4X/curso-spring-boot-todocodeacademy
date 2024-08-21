package com.saldoya.prueba.Restaurante.Controller;


import com.saldoya.prueba.Restaurante.Model.Plato;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestauranteController {

    @GetMapping("/plato")
    public String menu(@RequestParam Integer numeroDePlato){
        Plato plato0 = new Plato(1, "Muzza", 1000.00, "Muzza Muzza");
        Plato plato1 = new Plato(2, "Fuga", 2000.00, "Fuga Muzza");
        Plato plato2 = new Plato(3, "Calzon", 3000.00, "Calzon Muzza");
        Plato plato3 = new Plato(4, "Napo", 4000.00, "Muzza Napo");
        Plato plato4 = new Plato(5, "4 Quesos", 5000.00, "4 Quesos Muzza");
        Plato plato = Plato.getPlato(numeroDePlato);
        if(plato != null) return plato.toString();
        return "Plato no encontrado";
    }

}
