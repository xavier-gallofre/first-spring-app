package es.xgani.firstSpringApp.dto.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDto {

    private Integer id;
    private String name;
    private Date birthdate;
}
