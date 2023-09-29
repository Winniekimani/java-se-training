package com.systechafrika.possystemupdate.userdefinedexceptions;

public class MaxLoginAttemptsExceededException extends Exception {
    public MaxLoginAttemptsExceededException(String message) {
        super(message);
    }
}
