package com.java.insurance.exception;

public class StateNumberException extends Exception{
    public StateNumberException() {
    }

    public StateNumberException(String message) {
        super(message);
    }

    public StateNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
