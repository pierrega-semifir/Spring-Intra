package fr.piga.demospringdto.controller;

import fr.piga.demospringdto.dto.UserLocationDTO;
import fr.piga.demospringdto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    @ResponseStatus(OK)
    public List<UserLocationDTO> findAllUsers(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public UserLocationDTO findByUserId(@PathVariable long id){
        return service.findById(id);
    }


}
