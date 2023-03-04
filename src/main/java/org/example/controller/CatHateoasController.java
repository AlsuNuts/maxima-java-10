package org.example.controller;

import org.example.model.Cat;
import org.example.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/version2")
public class CatHateoasController {

    @Autowired
    private CatService catService;
    @Autowired private CatModelAssembler assembler;
    @GetMapping("/cats")
    public List<Cat> getAll(){
        return catService.getCats();
    }

    @GetMapping("/cat/{id}")
    public EntityModel<Cat> getOne(@PathVariable Long id){
        return assembler.toModel(catService.readCat(id));
    }
    @PostMapping("/cat")
    public HttpEntity<Cat> addCat(@RequestBody Cat cat) {
        return assembler.toModel(catService.saveCat(cat));
    }
    @GetMapping("/cat/{id}")
    public EntityModel<Cat> updateCat(@RequestBody Cat cat,@PathVariable Long id){
        return assembler.toModel(catService.updateCat(id, cat));
    }
    @GetMapping("/cat/{id}")
    public void deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
    }



}
