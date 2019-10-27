package es.xgani.firstSpringApp.controller.api.v1;

import es.xgani.firstSpringApp.controller.request.UserRequest;
import es.xgani.firstSpringApp.controller.resourceAssembler.UserResourceAssembler;
import es.xgani.firstSpringApp.dto.model.UserDto;
import es.xgani.firstSpringApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class UserRestController {

    private final UserService userService;

    private final UserResourceAssembler assembler;

    @GetMapping("/users")
    public CollectionModel<EntityModel<UserDto>> list() {
        List<UserDto> users = userService.findAll();
        return assembler.toCollectionModel(users);
    }

    @GetMapping("/users/{id}")
    public EntityModel<UserDto> show(@PathVariable Integer id) {
        UserDto user = userService.findById(id);
        return assembler.toModel(user);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<UserDto> create(@Valid @RequestBody UserRequest userRequest) {
        UserDto userDto = new UserDto()
                .setName(userRequest.getName())
                .setBirthdate(userRequest.getBirthdate());

        UserDto user = userService.create(userDto);
        return assembler.toModel(user);
    }

    @PutMapping("/users/{id}")
    public EntityModel<UserDto> replace(@PathVariable Integer id, @Valid @RequestBody UserRequest userRequest) {
        UserDto userDto = new UserDto()
                .setName(userRequest.getName())
                .setBirthdate(userRequest.getBirthdate());

        UserDto user = userService.replace(id, userDto);
        return assembler.toModel(user);
    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
