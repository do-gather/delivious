package com.delivious.backend.global.error.exception;

import com.delivious.backend.global.error.ErrorCode;
import com.delivious.backend.global.error.exception.BusinessException;

import java.util.UUID;

public class NotFoundException extends BusinessException {

    public NotFoundException(String resourceName, UUID id) {
        super(resourceName + " not found with id = " + id, ErrorCode.ENTITY_NOT_FOUND);
    }
}
