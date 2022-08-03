package com.delivious.backend.domain.orders.service;

import com.delivious.backend.domain.orders.dto.request.OrderCreateRequest;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    Order create(OrderCreateRequest dto);

    List<Order> search(UUID userId, UUID storeId, OrderStatus orderStatus);

    Order findById(UUID orderId);
}
