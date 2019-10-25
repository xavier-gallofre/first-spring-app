package es.xgani.firstSpringApp.service;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.dto.mapper.UserMapper;
import es.xgani.firstSpringApp.dto.model.UserDto;
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
        User user = repository.findById(id).orElse(null);
        return user != null ? UserMapper.toUserDto(user) : null;
    }
}
