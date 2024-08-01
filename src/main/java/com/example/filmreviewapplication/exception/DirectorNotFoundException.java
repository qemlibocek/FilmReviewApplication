package com.example.filmreviewapplication.exception;

public class DirectorNotFoundException extends RuntimeException{

    public DirectorNotFoundException() {
        super("Director not found");
    }
}
