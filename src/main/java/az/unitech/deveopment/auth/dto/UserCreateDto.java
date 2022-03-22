package az.unitech.deveopment.auth.dto;

import az.unitech.deveopment.auth.error.validation.DocumentPIN;
import lombok.Data;

@Data
public class UserCreateDto {

    private String name;
    private String surname;
    private String password;

    @DocumentPIN
    private String documentPin;

}