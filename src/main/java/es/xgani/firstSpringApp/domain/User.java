package es.xgani.firstSpringApp.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
public class User {

    private @Id
    @GeneratedValue
    Integer id; // database entity
    private String name;
    private Date birthdate;

    public User() {

    }

    public User(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

}
