package fr.piga.demospringdto.config;

import fr.piga.demospringdto.dto.UserLocationDTO;
import fr.piga.demospringdto.location.Location;
import fr.piga.demospringdto.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-18T10:01:46+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserLocationDTO userToDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserLocationDTO userLocationDTO = new UserLocationDTO();

        userLocationDTO.setUserId( user.getId() );
        userLocationDTO.setEmail( user.getEmail() );
        userLocationDTO.setPlace( userLocationPlace( user ) );
        userLocationDTO.setLatitude( userLocationLatitude( user ) );
        userLocationDTO.setLongitude( userLocationLongitude( user ) );

        return userLocationDTO;
    }

    @Override
    public List<UserLocationDTO> userToDTOList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserLocationDTO> list = new ArrayList<UserLocationDTO>( users.size() );
        for ( User user : users ) {
            list.add( userToDTO( user ) );
        }

        return list;
    }

    private String userLocationPlace(User user) {
        if ( user == null ) {
            return null;
        }
        Location location = user.getLocation();
        if ( location == null ) {
            return null;
        }
        String place = location.getPlace();
        if ( place == null ) {
            return null;
        }
        return place;
    }

    private double userLocationLatitude(User user) {
        if ( user == null ) {
            return 0.0d;
        }
        Location location = user.getLocation();
        if ( location == null ) {
            return 0.0d;
        }
        double latitude = location.getLatitude();
        return latitude;
    }

    private double userLocationLongitude(User user) {
        if ( user == null ) {
            return 0.0d;
        }
        Location location = user.getLocation();
        if ( location == null ) {
            return 0.0d;
        }
        double longitude = location.getLongitude();
        return longitude;
    }
}
