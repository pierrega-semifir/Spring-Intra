package fr.piga.demospringcrud.controller;

import fr.piga.demospringcrud.model.IngrediantQuantite;
import fr.piga.demospringcrud.service.IngrediantQuantiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quantites")
public class IngrediantQuantiteController {

    private IngrediantQuantiteService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<IngrediantQuantite> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public IngrediantQuantite findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public IngrediantQuantite save(@RequestBody IngrediantQuantite ingrediantQuantite){
        return service.save(ingrediantQuantite);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IngrediantQuantite deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
