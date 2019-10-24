package es.xgani.firstSpringApp.domain;

import java.util.Date;

public class User {

    private Integer id; // database entity
    protected String name;
    protected Date birthdate;

    public User(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}
