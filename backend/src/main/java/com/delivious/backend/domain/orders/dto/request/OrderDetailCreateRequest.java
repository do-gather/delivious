package com.delivious.backend.domain.orders.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

// 주문 상세 생성
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetailCreateRequest {

    @NotNull
    private UUID menuId;

    @NotNull
    private int price;

    @NotEmpty
    private String size;

    @NotNull
    private int count;

    @NotEmpty
    private String temperature;
}
