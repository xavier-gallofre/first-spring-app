package es.xgani.firstSpringApp.controller;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    private final UserRepository repository;

    public UserRestController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> list() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    User show(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

}
