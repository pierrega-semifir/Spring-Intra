package fr.piga.Spring.Core.exo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MainExo2 {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainExo2.class);

        Burger bigMac = context.getBean(Burger.class);
        bigMac.listIngrediant();
    }
}
