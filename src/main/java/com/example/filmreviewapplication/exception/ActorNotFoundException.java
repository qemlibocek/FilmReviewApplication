package com.example.filmreviewapplication.exception;

public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException() {
        super("Actor not found");
    }
}
