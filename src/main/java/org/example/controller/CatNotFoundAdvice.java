package org.example.controller;

import org.example.exceptions.CatNotFoundExceprion;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//этот клас возвращает exception для вызова несуществующего кота
@ControllerAdvice
public class CatNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(CatNotFoundExceprion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CatNotFoundHandler(CatNotFoundExceprion ex){
        return ex.getMessage();
    }
}
