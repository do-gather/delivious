package com.delivious.backend.domain.users.exception;

import com.delivious.backend.global.error.exception.NotFoundFieldException;

import java.util.UUID;

public class UserIdNotFoundException extends NotFoundFieldException {

    public UserIdNotFoundException(UUID id) {
        super("User", "id", id.toString());
    }
}
