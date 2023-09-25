package com.systechafrika.pos.customexceptions;

public class InsufficientPaymentException extends Exception {
    public InsufficientPaymentException(String message) {
        super(message);
    }
}
