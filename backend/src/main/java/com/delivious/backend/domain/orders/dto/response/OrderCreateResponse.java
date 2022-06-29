package com.delivious.backend.domain.orders.dto.response;

import com.delivious.backend.domain.orders.entity.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Getter
public class OrderCreateResponse {

    private Timestamp created_at;

    private UUID tableId;

    private int totalPrice;

    private int totalCount;

    private OrderStatus orderStatus;

}
