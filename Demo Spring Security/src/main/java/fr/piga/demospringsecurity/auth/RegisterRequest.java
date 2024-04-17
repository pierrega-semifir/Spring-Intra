package fr.piga.demospringsecurity.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequest {

    @NotBlank(message =" Le prenom doit être rempli")
    private String firstname;

    @NotBlank(message =" Le nom doit être rempli")
    private String lastname;
    @Email
    @NotBlank(message =" L'email doit être rempli")
    private String email;

    @NotBlank(message = "Le mot de passe doit etre rempli")
    @Size(min = 8, message = "Le mot de passe doit faire au moins 8 caractères de long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Le mot de passe doit contenir au minimum une Majuscule, une Minuscule et un Chiffre")
    private String password;
}
