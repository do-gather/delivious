package com.delivious.backend.domain.menu.exception;

import com.delivious.backend.global.error.exception.NotFoundFieldException;

import java.util.UUID;

public class MenuIdNotFoundException extends NotFoundFieldException {

    public MenuIdNotFoundException(UUID id) {
        super("Menu", "id", id.toString());
    }
}
