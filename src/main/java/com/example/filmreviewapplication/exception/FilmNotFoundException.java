package com.example.filmreviewapplication.exception;

public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException() {
        super("Film not found");
    }
}
