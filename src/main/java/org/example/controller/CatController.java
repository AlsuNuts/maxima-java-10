package org.example.controller;

import org.example.model.Cat;
import org.example.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/version1")
public class CatController {

    @Autowired
    private CatService catService;
    @GetMapping("/cats")
    public List<Cat> getAll(){
        return catService.getCats();
    }
    @GetMapping("/cat/{id}")
    public ResponseEntity <Cat> getOne(@PathVariable Long id){
        return ResponseEntity.ok(catService.readCat(id));
    }
    @PostMapping("/cat")
    public ResponseEntity<Cat> add(@RequestBody Cat cat){
        catService.saveCat(cat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/cat/{id}")
    public ResponseEntity<Cat> readCat(@PathVariable Long id){
        return catService.readCat(id);
    }


    @GetMapping("/cat/{id}")
    public ResponseEntity<Cat> update(@RequestBody Cat cat){
        return catService.updateCat(cat.getId(), cat);
    }
    @GetMapping("/cat/{id}")
    public void deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
   }


}
