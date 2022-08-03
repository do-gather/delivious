package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.Store;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {

    private UUID storeId;

    @NotNull
    private UUID userId;

    @Size(min = 3, max = 50)
    private String storeName;

    public static StoreResponse of(Store store) {
        return StoreResponse.builder()
                .storeId(store.getId())
                .userId(store.getUser().getId())
                .storeName(store.getStoreName())
                .build();
    }
}
