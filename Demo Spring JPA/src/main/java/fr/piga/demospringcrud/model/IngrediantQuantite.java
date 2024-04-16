package fr.piga.demospringcrud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class IngrediantQuantite {
    public IngrediantQuantite(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int quantite;

    @ManyToOne
    private Ingrediant ingredient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Ingrediant getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingrediant ingredient) {
        this.ingredient = ingredient;
    }
}
