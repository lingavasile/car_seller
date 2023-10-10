package com.vasile.linga;

public class InvalidRatingException extends RuntimeException{

    public InvalidRatingException(String message) {
        super(message);
    }
}
