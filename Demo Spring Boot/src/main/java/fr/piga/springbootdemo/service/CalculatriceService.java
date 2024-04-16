package fr.piga.springbootdemo.service;

import fr.piga.springbootdemo.model.Calculatrice;
import org.springframework.stereotype.Service;

@Service
public class CalculatriceService {

    public int addition(int a, int b){
        return a+b;
    }

    public int soustraction(int a, int b){
        return a-b;
    }

    public int multiplication(int a, int b){
        return a*b;
    }

    public int division(int a, int b){
        return a/b;
    }

    public int calcul(Calculatrice calculatrice){
        return switch (calculatrice.getOperation()) {
            case "+" -> addition(calculatrice.getNombre1(), calculatrice.getNombre2());
            case "-" -> soustraction(calculatrice.getNombre1(), calculatrice.getNombre2());
            case "*" -> multiplication(calculatrice.getNombre1(), calculatrice.getNombre2());
            case "/" -> division(calculatrice.getNombre1(), calculatrice.getNombre2());
            default -> 0;
        };
    }
}
