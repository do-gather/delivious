package com.delivious.backend.domain.users.exception;

import java.util.UUID;

public class StoreIdNotFoundException extends RuntimeException {

    public StoreIdNotFoundException() {
        super("해당 ID를 가진 상점이 존재하지 않습니다");
    }
}
