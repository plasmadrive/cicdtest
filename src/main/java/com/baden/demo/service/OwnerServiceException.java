package com.baden.demo.service;

public class OwnerServiceException extends Exception {

    public OwnerServiceException() {
    }

    public OwnerServiceException(String message) {
        super(message);
    }

    public OwnerServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
