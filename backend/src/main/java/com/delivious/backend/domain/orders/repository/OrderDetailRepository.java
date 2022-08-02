package com.delivious.backend.domain.orders.repository;

import com.delivious.backend.domain.orders.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {

}
