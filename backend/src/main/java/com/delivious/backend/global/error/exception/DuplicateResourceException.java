package com.delivious.backend.global.error.exception;

import com.delivious.backend.global.error.ErrorCode;

public class DuplicateResourceException extends BusinessException {

    public DuplicateResourceException(String resourceName) {
        super(resourceName + " already exists with the same information",
                ErrorCode.DUPLICATE_ENTITY);
    }
}
