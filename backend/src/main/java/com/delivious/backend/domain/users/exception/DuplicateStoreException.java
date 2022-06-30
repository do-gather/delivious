package com.delivious.backend.domain.users.exception;

public class DuplicateStoreException  extends RuntimeException {
    public DuplicateStoreException() {
        super();
    }
    public DuplicateStoreException(String message, Throwable cause) {
        super(message, cause);
    }
    public DuplicateStoreException(String message) {
        super(message);
    }
    public DuplicateStoreException(Throwable cause) {
        super(cause);
    }
}
