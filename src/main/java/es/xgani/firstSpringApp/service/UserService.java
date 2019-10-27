package es.xgani.firstSpringApp.service;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.dto.mapper.UserMapper;
import es.xgani.firstSpringApp.dto.model.UserDto;
import es.xgani.firstSpringApp.exception.UserNotFoundException;
import es.xgani.firstSpringApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : repository.findAll()) {
            userDtos.add(UserMapper.toUserDto(user));
        }

        return userDtos;
    }

    public UserDto findById(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toUserDto(user);
    }

    public UserDto create(UserDto userDto) {
        User user = new User()
                .setName(userDto.getName())
                .setBirthdate(userDto.getBirthdate());
        return UserMapper.toUserDto(repository.save(user));
    }

    public UserDto replace(Integer id, UserDto userDto) {
        User newUser = repository.findById(id).map(user -> {
            user.setName(userDto.getName())
                    .setBirthdate(userDto.getBirthdate());
            return repository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));

        return UserMapper.toUserDto(newUser);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
