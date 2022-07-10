package com.delivious.backend.domain.orders.dto.response;


import com.delivious.backend.domain.orders.entity.OrderDetailStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class OrderDetailStatusResponse {
    private OrderDetailStatus status;
    private UUID orderdetailId;
}

