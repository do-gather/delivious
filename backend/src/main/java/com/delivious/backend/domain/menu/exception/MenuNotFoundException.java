package com.delivious.backend.domain.menu.exception;

public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException() {
        super();
    }

    public MenuNotFoundException(String message) {
        super(message);
    }

    public MenuNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
