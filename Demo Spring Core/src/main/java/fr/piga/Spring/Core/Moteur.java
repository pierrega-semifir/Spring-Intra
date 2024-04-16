package fr.piga.Spring.Core;

import org.springframework.stereotype.Component;

@Component
public class Moteur {

    public void demarrer(){
        System.out.println("Le moteur démarre");
    }
}
