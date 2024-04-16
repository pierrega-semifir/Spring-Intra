package fr.piga.demospringcrud.repository;

import fr.piga.demospringcrud.model.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
}
