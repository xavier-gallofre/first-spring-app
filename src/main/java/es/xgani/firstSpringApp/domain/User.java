package es.xgani.firstSpringApp.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue
    private Integer id; // database entity

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Birthdate is mandatory")
    private Date birthdate;

    public User() {

    }

    public User(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

}
