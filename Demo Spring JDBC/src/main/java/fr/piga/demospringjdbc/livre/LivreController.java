package fr.piga.demospringjdbc.livre;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livres")
public class LivreController {

    private final LivreService service;


    public LivreController(LivreService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Livre> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Livre getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Livre create(@RequestBody Livre livre) {
        return service.save(livre);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/recherche/titre/{titre}")
    public List<Livre> searchByTitre(@PathVariable String titre) {
        return service.searchByTitre(titre);
    }
}
