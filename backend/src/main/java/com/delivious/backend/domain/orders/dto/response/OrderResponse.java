package com.delivious.backend.domain.orders.dto.response;


import com.delivious.backend.domain.orders.entity.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    @NotNull
    private UUID orderId;

    @NotNull
    private UUID userId;

    private UUID storeId;
    private int totalCount;
    private float totalPrice;
    private OrderStatus orderStatus;
    
}
