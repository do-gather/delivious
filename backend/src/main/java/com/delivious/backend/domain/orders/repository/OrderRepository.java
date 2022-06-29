package com.delivious.backend.domain.orders.repository;
import com.delivious.backend.domain.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface OrderRepository extends  JpaRepository<Order,UUID> {
    Order findByUserId (UUID orderId);
    Order findOrderById (UUID orderId);
    Order findOrderByUserId (UUID orderId);
}
