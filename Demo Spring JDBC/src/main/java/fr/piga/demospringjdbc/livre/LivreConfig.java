package fr.piga.demospringjdbc.livre;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class LivreConfig {

    @Bean
    public RowMapper<Livre> livreRowMapper() {
        return (rs, rowNum) -> {
            Livre livre = new Livre();
            livre.setId(rs.getLong("id"));
            livre.setTitre(rs.getString("titre"));
            livre.setAuteur(rs.getString("auteur"));
            livre.setAnnee(rs.getString("annee"));
            return livre;
        };
    }
}
