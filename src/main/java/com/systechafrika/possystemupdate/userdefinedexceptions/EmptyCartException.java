package com.systechafrika.possystemupdate.userdefinedexceptions;

public class EmptyCartException extends Exception {
    public EmptyCartException(String message) {
        super(message);
    }
}