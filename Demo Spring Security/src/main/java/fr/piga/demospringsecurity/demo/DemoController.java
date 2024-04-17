package fr.piga.demospringsecurity.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/")
    @Secured({"USER", "ADMIN"})
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Bienvenue sur l'api sécurisée !");
    }


    @GetMapping("/admin")
    @Secured("ADMIN")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("Bienvenue sur la page Admin");
    }


}
