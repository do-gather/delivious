package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    public StoreResponse toResponseDto(Store entity) {
        return StoreResponse.builder()
                .storeId(entity.getId())
                .storeName(entity.getStoreName())
                .userId(entity.getUser().getId())
                .build();
    }
}
