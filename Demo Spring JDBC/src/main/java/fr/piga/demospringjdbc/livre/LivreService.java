package fr.piga.demospringjdbc.livre;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivreService {

    private final LivreRepository repository;

    private final JdbcTemplate template;

    private final RowMapper<Livre> livreRowMapper;


    public LivreService(LivreRepository repository, JdbcTemplate template, RowMapper<Livre> livreRowMapper) {
        this.repository = repository;
        this.template = template;
        this.livreRowMapper = livreRowMapper;
    }

    public List<Livre> findAll() {
        return repository.findAll();
    }


    public Livre findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Le livre spécifié n'a pas été trouvé")
        );
    }

    public Livre save(Livre livre){
        return repository.save(livre);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Livre> searchByTitre(String titre) {
        return template.query("SELECT * FROM livre WHERE titre = ?", livreRowMapper, titre);
    }
}
