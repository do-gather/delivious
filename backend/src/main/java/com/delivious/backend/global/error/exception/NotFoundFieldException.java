package com.delivious.backend.global.error.exception;

import com.delivious.backend.global.error.ErrorCode;
import com.delivious.backend.global.error.exception.BusinessException;

public class NotFoundFieldException extends BusinessException {

    public NotFoundFieldException(String resourceName, String fieldName, String fieldValue) {
        super(resourceName + " not found with " + fieldName + " = " + fieldValue,
                ErrorCode.INNER_ENTITY_NOT_FOUND);
    }
}
