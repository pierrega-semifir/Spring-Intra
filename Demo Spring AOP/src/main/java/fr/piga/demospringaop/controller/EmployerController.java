package fr.piga.demospringaop.controller;

import fr.piga.demospringaop.model.Employer;
import fr.piga.demospringaop.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    private final EmployerService service;


    public EmployerController(EmployerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(OK)
    public List<Employer> getAllEmployer() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Employer getEmployerById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(CREATED)
    public Employer saveEmployer(@RequestBody Employer employer) throws Exception {
        return service.save(employer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(CREATED)
    public void deleteEmployerById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
