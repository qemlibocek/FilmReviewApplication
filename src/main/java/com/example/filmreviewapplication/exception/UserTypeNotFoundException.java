package com.example.filmreviewapplication.exception;

public class UserTypeNotFoundException extends RuntimeException {

    public UserTypeNotFoundException() {
        super("User type not found");
    }
}
