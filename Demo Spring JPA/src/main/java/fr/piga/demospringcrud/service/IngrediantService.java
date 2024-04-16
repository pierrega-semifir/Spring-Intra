package fr.piga.demospringcrud.service;

import fr.piga.demospringcrud.model.Ingrediant;
import fr.piga.demospringcrud.repository.IngrediantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IngrediantService {


    private final IngrediantRepository repository;

    public IngrediantService(IngrediantRepository repository) {
        this.repository = repository;
    }

    @Transactional(timeout = 5, readOnly = true)
    public List<Ingrediant> findAll() {
        return repository.findAll();
    }

    @Transactional(timeout = 5, readOnly = true)
    public Ingrediant findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException((HttpStatus.NOT_FOUND), "L'ingrediant recherché n'a pas été trouvé")
        );
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Ingrediant save(Ingrediant ingrediantToSave) {
        return repository.save(ingrediantToSave);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public Ingrediant deleteById(Long id){
        Ingrediant dataToDelete = this.findById(id);
        repository.deleteById(id);
        return dataToDelete;
    }
}
