package es.xgani.firstSpringApp.repository;

import es.xgani.firstSpringApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
