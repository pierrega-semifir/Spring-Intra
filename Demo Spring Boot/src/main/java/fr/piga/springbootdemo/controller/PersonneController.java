package fr.piga.springbootdemo.controller;

import fr.piga.springbootdemo.model.Personne;
import fr.piga.springbootdemo.service.PersonneService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
@RequiredArgsConstructor
public class PersonneController {

    private final PersonneService personneService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Personne> findAll(){
        return personneService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Personne findById(@PathVariable Long id){
        return personneService.findById(id);
    }

    @PostMapping("/add")
    public Personne save(@RequestBody Personne personne){
        return personneService.save(personne);
    }

    @DeleteMapping("/delete/{id}")
    public Personne save(@PathVariable Long id){
        return personneService.delete(id);
    }

    @PatchMapping("/patch/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Personne update(@PathVariable Long id, @RequestBody Personne personne) {
        personne.setId(id);
        personneService.update(personne);
        return personneService.findById(id);
    }
}
