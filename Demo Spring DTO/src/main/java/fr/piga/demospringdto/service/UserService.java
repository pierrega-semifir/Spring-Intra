package fr.piga.demospringdto.service;

import fr.piga.demospringdto.config.UserMapper;
import fr.piga.demospringdto.dto.UserLocationDTO;
import fr.piga.demospringdto.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    public List<UserLocationDTO> findAll() {
        return mapper.userToDTOList(repository.findAll());
    }

    public UserLocationDTO findById(long id){
        return mapper.userToDTO(repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Utilisateur introuvable")
        ));
    }

}
