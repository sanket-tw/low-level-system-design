package com.caching.exception;

public class StorageFullException extends Exception {

    public StorageFullException() {
    }

    public StorageFullException(String message) {
        super(message);
    }
}
