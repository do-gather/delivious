package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    /*
    public Store toEntity(StoreDto storeDto) {
        return Store.builder()
                //.user(storeDto.getUserId())
                .storeName(storeDto.getStoreName())
                .build();
    }
     */

    public StoreDto toResponseDto(Store entity) {
        return StoreDto.builder()
                .storeName(entity.getStoreName())
                .userId(entity.getUser().getUserId())
                .build();
    }
}



