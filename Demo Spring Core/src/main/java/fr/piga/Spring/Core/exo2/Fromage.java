package fr.piga.Spring.Core.exo2;

import org.springframework.stereotype.Component;

@Component
public class Fromage {

    private String nom = "Comté";

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
