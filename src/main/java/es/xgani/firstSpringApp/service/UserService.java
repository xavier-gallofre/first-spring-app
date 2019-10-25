package es.xgani.firstSpringApp.service;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
