package com.delivious.backend.domain.orders.dto.response;

import com.delivious.backend.domain.orders.entity.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class OrderInfo {

    private UUID orderId;

    private OrderStatus orderStatus;

    private Timestamp created_at;

    @Setter
    private List<OrderDetailUserResponse> orderDetailList;

    @Builder
    public OrderInfo(UUID orderId, OrderStatus orderStatus, Timestamp created_at) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.created_at = created_at;
    }
}
