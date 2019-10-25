package es.xgani.firstSpringApp.controller;

import es.xgani.firstSpringApp.dto.model.UserDto;
import es.xgani.firstSpringApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
