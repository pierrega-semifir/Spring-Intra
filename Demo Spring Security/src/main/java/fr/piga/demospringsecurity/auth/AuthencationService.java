package fr.piga.demospringsecurity.auth;

import fr.piga.demospringsecurity.config.JwtService;
import fr.piga.demospringsecurity.role.RoleRepository;
import fr.piga.demospringsecurity.user.User;
import fr.piga.demospringsecurity.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AuthencationService {

    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthencationService(AuthenticationManager authenticationManager, RoleRepository roleRepository, JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var userRole = roleRepository.findByName("USER").orElseThrow(
                () -> new IllegalStateException("Role USER introuvable")
        ); // recupere le role "USER"
        User user = User.builder()// Créer un nouvel utilisateur
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .locked(true)
                .enabled(true)
                .roles(List.of(userRole))
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var claims = new HashMap<String, Object>();
        var user = (User) auth.getPrincipal();

        claims.put("nomComplet", user.getFullName());

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var userRole = roleRepository.findByName("ADMIN").orElseThrow(
                () -> new IllegalStateException("Role ADMIN introuvable")
        ); // recupere le role "ADMIN"
        User admin = User.builder()// Créer un nouvel utilisateur
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .locked(true)
                .enabled(true)
                .roles(List.of(userRole))
                .build();

        userRepository.save(admin);
        String jwtToken = jwtService.generateToken(admin);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }

}
