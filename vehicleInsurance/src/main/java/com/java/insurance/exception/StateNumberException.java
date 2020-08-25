package com.java.insurance.exception;

public class StateNumberException extends Exception{
    private String code;

    public StateNumberException() {
    }

    public StateNumberException(String code, String message) {
        super(message);
        this.code = code;
    }

    public StateNumberException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }


    public String getCode() {
        return code;
    }
}

