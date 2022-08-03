package com.delivious.backend.domain.category.exception;

import com.delivious.backend.global.error.exception.NotFoundFieldException;

import java.util.UUID;

public class CategoryIdNotFoundException extends NotFoundFieldException {

    public CategoryIdNotFoundException(UUID id) {
        super("Category", "id", id.toString());
    }
}
