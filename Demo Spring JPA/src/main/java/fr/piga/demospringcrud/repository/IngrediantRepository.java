package fr.piga.demospringcrud.repository;

import fr.piga.demospringcrud.model.Ingrediant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngrediantRepository extends JpaRepository<Ingrediant, Long> {
}
