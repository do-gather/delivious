package com.delivious.backend.domain.menu.exception;

public class MenuAlreadyExists extends RuntimeException{
    public MenuAlreadyExists(String msg) {
        super(msg);
    }
}
