package az.unitech.deveopment.auth.dto;

import lombok.Data;

@Data
public class UserCreateDto {

    private String name;
    private String surname;
    private String password;
    private String documentPin;

}
