package fr.piga.demospringdto.config;


import fr.piga.demospringdto.dto.UserLocationDTO;
import fr.piga.demospringdto.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "location.place", target = "place")
    @Mapping(source = "location.latitude", target = "latitude")
    @Mapping(source = "location.longitude", target = "longitude")
    UserLocationDTO userToDTO(User user);

    List<UserLocationDTO> userToDTOList(List<User> users);
}
