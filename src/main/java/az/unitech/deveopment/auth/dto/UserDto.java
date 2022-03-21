package az.unitech.deveopment.auth.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String documentPin;

}