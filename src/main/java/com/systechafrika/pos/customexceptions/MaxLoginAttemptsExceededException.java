package com.systechafrika.pos.customexceptions;

public class MaxLoginAttemptsExceededException extends Exception {
    public MaxLoginAttemptsExceededException(String message) {
        super(message);
    }
}
