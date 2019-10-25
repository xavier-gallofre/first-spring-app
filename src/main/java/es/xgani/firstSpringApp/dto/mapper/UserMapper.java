package es.xgani.firstSpringApp.dto.mapper;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.dto.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setName(user.getName())
                .setBirthdate(user.getBirthdate());
    }
}
