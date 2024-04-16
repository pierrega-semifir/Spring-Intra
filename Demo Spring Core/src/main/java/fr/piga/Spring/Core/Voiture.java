package fr.piga.Spring.Core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Voiture {
    private final Moteur moteur;

    public Voiture(Moteur moteur){
        this.moteur = moteur;
    }

    public void rouler(){
        moteur.demarrer();
    }
}
