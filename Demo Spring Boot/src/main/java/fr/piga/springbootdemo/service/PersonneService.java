package fr.piga.springbootdemo.service;

import fr.piga.springbootdemo.model.Personne;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonneService {

    public final List<Personne> personnesListe = new ArrayList<>();

    public List<Personne> findAll(){
        return personnesListe;
    }

    public Personne findById(Long id){
        for (Personne personne : personnesListe) {
            if(personne.getId().equals(id)) {
                return personne;
            }
        }
        return null;
    }

    public Personne save(Personne personneToSave) {
        personnesListe.add(personneToSave);
        return personneToSave;
    }

    public void update(Personne personneToUpdate) {
        for(Personne p : personnesListe){
            if(p.getId().equals(personneToUpdate.getId())) {

                if(personneToUpdate.getPrenom().isEmpty()){
                    p.setPrenom(p.getPrenom());
                }else {
                    p.setPrenom((personneToUpdate.getPrenom()));
                }

                if(personneToUpdate.getNom().isEmpty()){
                    p.setNom(p.getNom());
                }else {
                    p.setNom((personneToUpdate.getNom()));
                }

                if(personneToUpdate.getAge().isEmpty()){
                    p.setAge(p.getAge());
                }else {
                    p.setAge((personneToUpdate.getAge()));
                }
            }
        }
    }

    public Personne delete(Long id) {
        for (Personne p : personnesListe) {
            if (p.getId().equals(id)) {
                personnesListe.remove(p);
                return p;
            }
        }
        return null;
    }
}
