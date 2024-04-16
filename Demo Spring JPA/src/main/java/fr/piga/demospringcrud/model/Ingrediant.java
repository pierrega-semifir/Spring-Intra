package fr.piga.demospringcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name= "ingrediants")
public class Ingrediant {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    public Ingrediant() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
