package com.systechafrika.possystemupdate.userdefinedexceptions;

public class InsufficientPaymentException extends Exception {
    public InsufficientPaymentException(String message) {
        super(message);
    }
}
