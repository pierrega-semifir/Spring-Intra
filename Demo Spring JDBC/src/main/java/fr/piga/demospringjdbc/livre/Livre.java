package fr.piga.demospringjdbc.livre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livre {

    @Id
    @GeneratedValue
    private Long id;

    private String titre;

    private String auteur;

    private String annee;

    public Livre() {
    }

    public Livre(Long id, String titre, String auteur, String annee) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
    }

}
