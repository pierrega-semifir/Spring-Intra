package fr.piga.demospringsecurity;

import fr.piga.demospringsecurity.role.Role;
import fr.piga.demospringsecurity.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {
        return (args) -> {
            if(roleRepository.findByName("USER").isEmpty()) {
                roleRepository.save(
                        Role.builder().name("USER").build()
                );
            }
            if(roleRepository.findByName("ADMIN").isEmpty()) {
                roleRepository.save(
                        Role.builder().name("ADMIN").build()
                );
            }
        };
    }

}
