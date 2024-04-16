package fr.piga.Spring.Core.exo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExo3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean("bigMac", Burger.class).listIngrediant();


    }
}
