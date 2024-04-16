package fr.piga.demospringcrud.service;

import fr.piga.demospringcrud.model.Categorie;
import fr.piga.demospringcrud.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository repository;

    public CategorieService(CategorieRepository repository) {
        this.repository = repository;
    }

    public List<Categorie> findAll(){
        return repository.findAll();
    }

    public Categorie findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categorie introuvable")
        );
    }

    public Categorie save(Categorie categorieToSave) {
        return repository.save(categorieToSave);
    }

    public Categorie deleteById(Long id) {
        Categorie categorie = this.findById(id);
        repository.deleteById(id);
        return categorie;
    }
}
