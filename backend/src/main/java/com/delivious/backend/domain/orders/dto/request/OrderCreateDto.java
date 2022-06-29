package com.delivious.backend.domain.orders.dto.request;


import com.delivious.backend.domain.orders.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class OrderCreateDto {

    private UUID store_id;

    private List<OrderDetailCreateDto> orderDetailList;

    private int totalPrice;

}
