package com.delivious.backend.domain.orders.dto.response;

import com.delivious.backend.domain.orders.entity.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
// 관리자 주문 화면에 들어갈 dto
@Getter
@NoArgsConstructor
public class OrderInfo {

    private UUID orderId;

    private OrderStatus orderStatus;

    private LocalDateTime created_at;

    @Setter
    private List<OrderDetailUserResponse> orderDetailList;

    @Builder
    public OrderInfo(UUID orderId, OrderStatus orderStatus, LocalDateTime created_at, List<OrderDetailUserResponse> orderDetailList) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.created_at = created_at;
        this.orderDetailList = orderDetailList;
    }
}


