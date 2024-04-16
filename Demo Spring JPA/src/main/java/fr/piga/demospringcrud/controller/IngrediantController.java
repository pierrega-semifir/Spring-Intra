package fr.piga.demospringcrud.controller;

import fr.piga.demospringcrud.model.Ingrediant;
import fr.piga.demospringcrud.service.IngrediantService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ingrediants")

public class IngrediantController {

    private final IngrediantService service;

    public IngrediantController(IngrediantService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Ingrediant> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ingrediant findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingrediant save(@RequestBody Ingrediant ingrediant){
        return service.save(ingrediant);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ingrediant deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
