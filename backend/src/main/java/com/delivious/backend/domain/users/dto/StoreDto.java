package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String storeName;


    public static StoreDto from(Store store){
        if(store == null) return null;

        return StoreDto.builder()
                .storeName(store.getStoreName())
                .build();
    }


}
