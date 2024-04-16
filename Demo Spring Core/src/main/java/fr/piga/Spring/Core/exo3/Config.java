package fr.piga.Spring.Core.exo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Pain pain(){
        return new Pain();
    }

    @Bean
    public Fromage fromage(){
        return new Fromage();
    }

    @Bean
    public Steack steack(){
        return new Steack();
    }

    @Bean
    public Salade salade(){
        return new Salade();
    }

    @Bean(name= "bigMac")
    public Burger burger(){
        return new Burger(pain(), salade(), steack(), fromage());
    }
}
