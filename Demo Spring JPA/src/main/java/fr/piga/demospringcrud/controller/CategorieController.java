package fr.piga.demospringcrud.controller;

import fr.piga.demospringcrud.model.Categorie;
import fr.piga.demospringcrud.service.CategorieService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategorieController {

    private CategorieService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Categorie> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Categorie findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie save(@RequestBody Categorie categorie){
        return service.save(categorie);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categorie deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
