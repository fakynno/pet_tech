package br.com.fiap.pet_tech.pet_tech.exceptions;

public class ControllerNotFoundException extends RuntimeException{
    
    public ControllerNotFoundException(String message) {
        super(message);
    }    

}
