package com.delivious.backend.domain.menu.exception;

public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException(String msg) {
        super(msg);
    }
}
