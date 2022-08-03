package com.delivious.backend.domain.users.exception;

import com.delivious.backend.global.error.exception.NotFoundFieldException;

import java.util.UUID;

public class StoreIdNotFoundException extends NotFoundFieldException {

    public StoreIdNotFoundException(UUID id) {
        super("Store", "id", id.toString());
    }
}
