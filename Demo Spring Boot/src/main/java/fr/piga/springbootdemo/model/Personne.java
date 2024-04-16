package fr.piga.springbootdemo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Personne {
    private Long id;
    private String prenom;
    private String nom;
    private String age;
}
