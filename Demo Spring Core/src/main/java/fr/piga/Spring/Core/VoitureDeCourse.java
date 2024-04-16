package fr.piga.Spring.Core;

import org.springframework.stereotype.Component;


public class VoitureDeCourse {

    private final Moteur moteur;

    public VoitureDeCourse(Moteur moteur){
        this.moteur = moteur;
    }

    public void rouler(){
        moteur.demarrer();
    }
}
