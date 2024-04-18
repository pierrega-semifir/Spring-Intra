package fr.piga.demoOauth2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logged")
public class LoggedController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String bienvenue(){
        return "Bienvenue sur notre application securisé par Oauth2";
    }
}
