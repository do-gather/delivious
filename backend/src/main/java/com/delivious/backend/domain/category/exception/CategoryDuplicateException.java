package com.delivious.backend.domain.category.exception;

public class CategoryDuplicateException extends RuntimeException {

    public CategoryDuplicateException(String message) {
        super(message);
    }
}
