package fr.piga.demospringcrud.service;

import fr.piga.demospringcrud.model.IngrediantQuantite;
import fr.piga.demospringcrud.repository.IngrediantQuantiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IngrediantQuantiteService {

    private final IngrediantQuantiteRepository repository;

    public IngrediantQuantiteService(IngrediantQuantiteRepository repository) {
        this.repository = repository;
    }

    @Transactional(timeout = 5, readOnly = true)
    public List<IngrediantQuantite> findAll(){
        return repository.findAll();
    }

    @Transactional(timeout = 5, readOnly = true)
    public IngrediantQuantite findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quantite introuvable")
        );
    }

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public IngrediantQuantite save(IngrediantQuantite ingrediantQuantiteToSave) {
        return repository.save(ingrediantQuantiteToSave);
    }

    @Transactional(propagation = Propagation.NEVER)
    public IngrediantQuantite deleteById(Long id) {
        IngrediantQuantite quatite = this.findById(id);
        repository.deleteById(id);
        return quatite;
    }
}
