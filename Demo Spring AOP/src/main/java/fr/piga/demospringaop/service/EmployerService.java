package fr.piga.demospringaop.service;

import fr.piga.demospringaop.model.Employer;
import fr.piga.demospringaop.repository.EmployerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class EmployerService {

    private final EmployerRepository repository;


    public EmployerService(EmployerRepository repository) {
        this.repository = repository;
    }

    public List<Employer> findAll() {
        return repository.findAll();
    }

    public Employer findById(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(NOT_FOUND, "Employer introuvable")
        );
    }

    public Employer save(Employer employer) throws Exception {
        if(employer.getName().length() > 7)
            throw new Exception("Votre nom est trop long");
        return repository.save(employer);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
