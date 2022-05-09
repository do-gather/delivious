package com.delivious.backend.domain.orders.repository;
import com.delivious.backend.domain.orders.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends  JpaRepository<OrderEntity,UUID> {
}
