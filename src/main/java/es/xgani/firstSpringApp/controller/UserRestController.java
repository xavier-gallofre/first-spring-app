package es.xgani.firstSpringApp.controller;

import es.xgani.firstSpringApp.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping(path = "users")
public class UserRestController {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @GetMapping
    public User me() throws ParseException {
        return new User("Xavier Gallofré Nieva", SIMPLE_DATE_FORMAT.parse("03/04/1988"));
    }
}
