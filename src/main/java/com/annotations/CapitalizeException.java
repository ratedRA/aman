package com.annotations;

public class CapitalizeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public CapitalizeException(String message){
        super(message);
    }
}
