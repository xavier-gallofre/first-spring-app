package es.xgani.firstSpringApp.controller.api;

import es.xgani.firstSpringApp.controller.request.UserRequest;
import es.xgani.firstSpringApp.dto.model.UserDto;
import es.xgani.firstSpringApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    @GetMapping("/users")
    List<UserDto> list() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    UserDto show(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    UserDto create(@RequestBody UserRequest userRequest) {
        UserDto userDto = new UserDto()
                .setName(userRequest.getName())
                .setBirthdate(userRequest.getBirthdate());

        return userService.create(userDto);
    }
}