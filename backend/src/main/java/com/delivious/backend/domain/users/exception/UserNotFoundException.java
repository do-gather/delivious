package com.delivious.backend.domain.users.exception;

import com.delivious.backend.global.error.exception.NotFoundException;

import java.util.UUID;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(UUID id) {
        super("User", id);
    }
}
