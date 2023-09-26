package com.systechafrika.poswithinsertanddeletedata.customexceptions;

public class InsufficientPaymentException extends Exception {
    public InsufficientPaymentException(String message) {
        super(message);
    }
}
