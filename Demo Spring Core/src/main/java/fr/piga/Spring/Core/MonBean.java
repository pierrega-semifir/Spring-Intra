package fr.piga.Spring.Core;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MonBean {
    private static int compteur = 0;

    public MonBean() {
        compteur++;
        System.out.println("Je suis le bean numéro : "+ compteur);
    }
}
