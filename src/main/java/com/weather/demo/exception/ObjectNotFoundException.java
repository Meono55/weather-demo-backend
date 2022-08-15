package com.weather.demo.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(String message){
        super(message);
    }
}
