package az.unitech.deveopment.auth.mapper;

import az.unitech.deveopment.auth.domain.User;
import az.unitech.deveopment.auth.dto.UserCreateDto;
import az.unitech.deveopment.auth.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreateDto userCreateDto);

    UserDto toUserDto(User user);

}