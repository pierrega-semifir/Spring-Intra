package fr.piga.demospringcrud.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
public class Recette {

    public Recette(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String description;

    @OneToMany
    public List<IngrediantQuantite> ingredientQuantite;

    @ManyToMany(mappedBy = "recettes")
    public List<Categorie> categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IngrediantQuantite> getIngredientQuantite() {
        return ingredientQuantite;
    }

    public void setIngredientQuantite(List<IngrediantQuantite> ingredientQuantite) {
        this.ingredientQuantite = ingredientQuantite;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}