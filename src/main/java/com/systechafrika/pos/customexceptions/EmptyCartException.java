package com.systechafrika.pos.customexceptions;

public class EmptyCartException extends Exception {
    public EmptyCartException(String message) {
        super(message);
    }
}