package com.delivious.backend.domain.orders.exception;

import com.delivious.backend.global.error.exception.NotFoundException;

import java.util.UUID;

public class OrderNotFoundException extends NotFoundException {

    public OrderNotFoundException(UUID id) {
        super("Order", id);
    }
}
