package fr.piga.demospringdto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLocationDTO {

    private long userId;

    @Email @NotBlank
    private String email;

    @NotBlank
    private String place;

    @NotBlank
    private double latitude;

    @NotBlank
    private double longitude;
}
