package es.xgani.firstSpringApp.controller.resourceAssembler;

import es.xgani.firstSpringApp.controller.api.UserRestController;
import es.xgani.firstSpringApp.dto.model.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserResourceAssembler implements RepresentationModelAssembler<UserDto, EntityModel<UserDto>> {

    @Override
    public EntityModel<UserDto> toModel(UserDto user) {
        return new EntityModel<>(user,
                linkTo(methodOn(UserRestController.class).show(user.getId())).withSelfRel(),
                linkTo(methodOn(UserRestController.class).list()).withRel("/users"));
    }

    public CollectionModel<EntityModel<UserDto>> toCollectionModel(List<UserDto> users) {
        List<EntityModel<UserDto>> resources = users.stream()
                .map(this::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(resources,
                linkTo(methodOn(UserRestController.class).list()).withSelfRel()
        );
    }
}
