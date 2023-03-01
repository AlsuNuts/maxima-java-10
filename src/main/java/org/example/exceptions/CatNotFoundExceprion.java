package org.example.exceptions;

public class CatNotFoundExceprion extends RuntimeException{
    public CatNotFoundExceprion(String message) {
        super("нет такого кота:" + message);
    }
}
