package fr.piga.demospringdto;

import fr.piga.demospringdto.location.Location;
import fr.piga.demospringdto.location.LocationRepository;
import fr.piga.demospringdto.user.User;
import fr.piga.demospringdto.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringDtoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDtoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void run(String[] args) throws Exception{

        Location lille = new Location();
        lille.setPlace("Lille");
        lille.setDescription(("C'est une ville du nord"));
        lille.setLatitude(50.62925);
        lille.setLongitude(3.057256);
        locationRepository.save(lille);

        User user1 = new User();
        user1.setNom("Pierre");
        user1.setPrenom("Gaillard");
        user1.setEmail("pierre.gaillard@live.fr");
        user1.setLocation(lille);
        userRepository.save(user1);

        User user2 = new User();
        user2.setNom("Emilie");
        user2.setPrenom("Gaillard");
        user2.setEmail("emilie.gaillard@live.fr");
        user2.setLocation(lille);
        userRepository.save(user2);

    }

}
