/*

 */
package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.User;
import lombok.*;

import com.delivious.backend.domain.users.entity.Store;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

    @NotNull
    private UUID storeId;

    @NotNull
    @Size(min = 3, max = 50)
    private String storeName;

    public static StoreDto from(Store store){   //user 을 추가해버리면 스토어서비스에서 에러가 생긴다..
        if(store == null) return null;

        return StoreDto.builder()
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .build();
    }


}
