package fr.piga.demospringsecurity.config;

import fr.piga.demospringsecurity.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
       return repository.findByEmail(userEmail).orElseThrow(
               () -> new UsernameNotFoundException("Utilisateur non trouvé avec cette email : " + userEmail)
       );
    }
}
