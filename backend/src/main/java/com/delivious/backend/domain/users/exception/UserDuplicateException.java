package com.delivious.backend.domain.users.exception;

import com.delivious.backend.global.error.exception.DuplicateResourceException;

public class UserDuplicateException extends DuplicateResourceException {

    public UserDuplicateException() {
        super("User");
    }
}
