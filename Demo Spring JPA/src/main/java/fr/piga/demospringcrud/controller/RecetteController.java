package fr.piga.demospringcrud.controller;

import fr.piga.demospringcrud.model.Recette;
import fr.piga.demospringcrud.service.RecetteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/recettes")
public class RecetteController {

    private RecetteService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Recette> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Recette findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Recette save(@RequestBody Recette recette){
        return service.save(recette);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recette deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
