package fr.piga.Spring.Core.exo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExo1 {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        context.register(Steack.class, Salade.class, Fromage.class, Pain.class, Burger.class);
        context.getBean(Burger.class).listIngrediant();

        context.close();
    }
}
