package com.delivious.backend.domain.orders.dto.response;

import com.delivious.backend.domain.orders.entity.InOut;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.orders.entity.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponse {

    //private UUID tableId;

    private UUID orderId;

    private int totalPrice;

    private int totalCount;

    private InOut inOut;

    private OrderStatus status;

    private Set<OrderDetailResponse> orderDetails = new LinkedHashSet<>();

    private LocalDateTime createdAt;

    public static OrderResponse of(Order order) {
        return OrderResponse.builder()
                .orderId(order.getId())
                .totalPrice(order.getOrderDetails().stream().map(OrderDetail::getDetailTotalPrice).reduce(0, Integer::sum))
                .totalCount(order.getOrderDetails().size())
                .inOut(order.getInOut())
                .status(order.getStatus())
                .orderDetails(order.getOrderDetails().stream().map(OrderDetailResponse::of).collect(Collectors.toSet()))
                .createdAt(order.getCreatedAt())
                .build();
    }
}
