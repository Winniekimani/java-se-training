package com.systechafrika.poswithinsertanddeletedata.customexceptions;

public class MaxLoginAttemptsExceededException extends Exception {
    public MaxLoginAttemptsExceededException(String message) {
        super(message);
    }
}
