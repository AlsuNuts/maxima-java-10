package org.example.service;

import org.example.exceptions.CatNotFoundExceprion;
import org.example.model.Cat;
import org.example.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CatService {
    @Autowired
    private CatRepository repository;
    @PostConstruct
    public void init(){
        repository.save(new Cat("Мурзик", 10, true));
        repository.save(new Cat("Пушок", 7, false));
        repository.save(new Cat("Кусец", 10, true));
    }
    public List<Cat> getCats(){
        return repository.findAll();
    }
    public void saveCat(Cat newCat){
        repository.save(newCat);
    }
    public ResponseEntity<Cat> readCat(Long id){
        return repository.findById(id).orElseThrow(()->new CatNotFoundExceprion(id.toString()));
    }
    public ResponseEntity<Cat> updateCat(Long id, Cat cat){
        repository.findById(id).orElseThrow();
        Cat updateCat = repository.getById(id);

        updateCat.setId(cat.getId());
        updateCat.setName(cat.getName());
        updateCat.setWeight(cat.getWeight());
        updateCat.setAngry(cat.isAngry());
        return repository.save(updateCat);
    }
    public void deleteCat(Long id){
        repository.deleteById(id);
    }
}
