package com.delivious.backend.domain.category.exception;

import com.delivious.backend.global.error.exception.DuplicateResourceException;

public class CategoryDuplicateException extends DuplicateResourceException {

    public CategoryDuplicateException() {
        super("Category");
    }
}
