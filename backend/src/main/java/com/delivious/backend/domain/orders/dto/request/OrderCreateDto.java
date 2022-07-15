package com.delivious.backend.domain.orders.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class OrderCreateDto {

    private UUID storeId;

    private String username;

    private List<OrderDetailCreate> orderDetailList;

    private int totalCount;

    private int totalPrice;




}
