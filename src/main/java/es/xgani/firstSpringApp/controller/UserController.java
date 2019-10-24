package es.xgani.firstSpringApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/sayHey")
    public String sayHey() {
        return "Hello World!";
    }
}
