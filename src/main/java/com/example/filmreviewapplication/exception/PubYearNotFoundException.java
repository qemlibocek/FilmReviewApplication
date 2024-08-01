package com.example.filmreviewapplication.exception;

import com.example.filmreviewapplication.model.entity.PublicationYear;

public class PubYearNotFoundException extends RuntimeException {

    public PubYearNotFoundException() {
        super("Publication year not found");
    }
}
