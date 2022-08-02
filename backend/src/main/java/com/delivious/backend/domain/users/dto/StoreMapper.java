package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    public StoreResponseDto toResponseDto(Store entity) {
        return StoreResponseDto.builder()
                .storeId(entity.getId())
                .storeName(entity.getStoreName())
                .userId(entity.getUser().getUserId())
                .build();
    }
}
