package db.dto;

import org.mapstruct.Mapper;
import db.quarkus.User;

@Mapper(componentModel="cdi")
public interface UserMapper {
    UserDto toDto(User user);
    List<UserDto> toDto(List<User> user);
}