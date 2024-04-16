package fr.piga.springbootdemo.controller;

import fr.piga.springbootdemo.model.Calculatrice;
import fr.piga.springbootdemo.service.CalculatriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculatrice")
@RequiredArgsConstructor
public class CalculatriceController {

    private final CalculatriceService calculatriceService;

//    public CalculatriceController(CalculatriceService calculatriceService) {
//        this.calculatriceService = calculatriceService;
//    }

    @PostMapping("/addition")
    public int addition(int a, int b){
        return calculatriceService.addition(a, b);
    }

    @PostMapping("/soustraction")
    public int soustraction(int a, int b){
        return calculatriceService.soustraction(a, b);
    }

    @PostMapping("/multiplication")
    public int multiplication(int a, int b){
        return calculatriceService.multiplication(a, b);
    }

    @PostMapping("/division")
    public int division(int a, int b){
        return calculatriceService.division(a, b);
    }

    @PostMapping("/calcul")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int calcul(@RequestBody Calculatrice calculatrice) throws Exception{
        return calculatriceService.calcul(calculatrice);
    }
}
