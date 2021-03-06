package com.delivious.backend.domain.orders.dto.request;

import com.delivious.backend.domain.orders.entity.OrderDetailStatus;
import com.delivious.backend.domain.orders.entity.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;
// 주문 상세 - 유저 키오스크

@Builder
@Getter
public class OrderDetailBill {

    private UUID orderId;

    private UUID orderdetailId;

    private String menuName;

    private OrderDetailStatus status;

    private LocalDateTime orderDate;
}
