package com.delivious.backend.domain.category.exception;

import com.delivious.backend.global.error.exception.NotFoundException;

import java.util.UUID;

public class CategoryNotFoundException extends NotFoundException {

    public CategoryNotFoundException(UUID id) {
        super("Category", id);
    }
}
