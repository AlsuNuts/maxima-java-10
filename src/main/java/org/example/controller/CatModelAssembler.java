package org.example.controller;

import org.example.model.Cat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CatModelAssembler implements RepresentationModelAssembler<Cat, EntityModel<Cat>> {


    @Override
    public EntityModel<Cat> toModel(Cat entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(CatHateoasController.class).getOne(entity.getId())).withSelfRel(),
                linkTo(methodOn(CatHateoasController.class).getAll()).withRel("band")
                );
    }

    @Override
    public CollectionModel<EntityModel<Cat>> toCollectionModel(Iterable<? extends Cat> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
