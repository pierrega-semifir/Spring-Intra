package fr.piga.demospringcrud.repository;

import fr.piga.demospringcrud.model.Ingrediant;
import fr.piga.demospringcrud.model.IngrediantQuantite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngrediantQuantiteRepository extends JpaRepository<IngrediantQuantite, Long> {

}
