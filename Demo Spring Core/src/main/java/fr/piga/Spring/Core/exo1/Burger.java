package fr.piga.Spring.Core.exo1;

public class Burger {

    private final Pain pain;
    private final Fromage fromage;
    private final Steack steack;
    private final Salade salade;

    public Burger(Pain pain, Salade salade, Steack steack, Fromage fromage) {
        this.pain = pain;
        this.salade = salade;
        this.steack = steack;
        this.fromage = fromage;
    }

    public void listIngrediant(){
        System.out.println("Voici ma composition : ");
        System.out.println(" -Pain "+ pain.getNom());
        System.out.println(" -Fromage "+ fromage.getNom());
        System.out.println(" -Steack" + steack.getNom());
        System.out.println(" -Salade" + salade.getNom());
    }
}
