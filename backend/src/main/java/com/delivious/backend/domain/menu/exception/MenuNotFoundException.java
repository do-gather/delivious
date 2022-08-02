package com.delivious.backend.domain.menu.exception;

import com.delivious.backend.global.error.exception.NotFoundException;

import java.util.UUID;

public class MenuNotFoundException extends NotFoundException {

    public MenuNotFoundException(UUID id) {
        super("Menu", id);
    }
}
