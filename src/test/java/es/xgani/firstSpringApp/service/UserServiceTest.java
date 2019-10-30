package es.xgani.firstSpringApp.service;

import es.xgani.firstSpringApp.domain.User;
import es.xgani.firstSpringApp.exception.UserNotFoundException;
import es.xgani.firstSpringApp.repository.UserRepository;
import es.xgani.firstSpringApp.util.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void whenFindUserAndNotExists_thenThrowsException() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.findById(1));
    }

    @Test
    public void whenFindUserAndExists_thenDontThrowsException() throws ParseException {
        User user = new User("Xavi", DateUtils.parse("03/04/1988"));
        when(userRepository.findById(isA(Integer.class))).thenReturn(Optional.of(user));
        Assertions.assertDoesNotThrow(() -> userService.findById(1));
    }
}
