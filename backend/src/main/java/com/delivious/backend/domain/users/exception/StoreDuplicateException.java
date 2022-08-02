package com.delivious.backend.domain.users.exception;

import com.delivious.backend.global.error.exception.DuplicateResourceException;

public class StoreDuplicateException extends DuplicateResourceException {

    public StoreDuplicateException() {
        super("Store");
    }
}
