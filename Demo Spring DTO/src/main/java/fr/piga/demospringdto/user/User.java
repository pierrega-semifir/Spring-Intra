package fr.piga.demospringdto.user;

import fr.piga.demospringdto.location.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String email;
    private String prenom;
    private String nom;
    private String password;

    @ManyToOne
    private Location location;
}
