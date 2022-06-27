package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.User;
import lombok.*;

import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreDto {


    @NotNull
    private UUID userId;

    @Size(min = 3, max = 50)
    private String storeName;

    public static StoreDto from(Store store, User user){
        if(store == null) return null;

        return StoreDto.builder()
                .userId(user.getUserId())
                .storeName(store.getStoreName())
                .build();
    }


}

