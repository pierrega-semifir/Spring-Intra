package fr.piga.demospringcrud.service;

import fr.piga.demospringcrud.model.Categorie;
import fr.piga.demospringcrud.model.Recette;
import fr.piga.demospringcrud.repository.CategorieRepository;
import fr.piga.demospringcrud.repository.RecetteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(timeout = 5, propagation = Propagation.MANDATORY, isolation = Isolation.SERIALIZABLE)
public class RecetteService {

    private final RecetteRepository repository;

    public RecetteService(RecetteRepository repository) {
        this.repository = repository;
    }

    public List<Recette> findAll(){
        return repository.findAll();
    }

    public Recette findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette introuvable")
        );
    }

    public Recette save(Recette reetteToSave) {
        return repository.save(reetteToSave);
    }

    public Recette deleteById(Long id) {
        Recette recette = this.findById(id);
        repository.deleteById(id);
        return recette;
    }
}
